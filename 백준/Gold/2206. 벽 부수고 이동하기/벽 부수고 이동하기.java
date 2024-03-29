import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord {
    int x;
    int y;
    int dis;
    boolean wallBreak;

    public Coord(int x, int y, int dis, boolean wallBreak) {
        super();
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.wallBreak = wallBreak;
    }
}

public class Main {
    static int n, m;
    static int[][] map; // 맵. n x m. 인덱스 1부터 시작
    static boolean[][][] visited; // 방문 체크 배열
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int totalDis = bfs(new Coord(0, 0, 1, false));
        sb.append(totalDis);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(Coord coord) {
        Queue<Coord> q = new LinkedList<>();
        q.offer(coord);
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Coord cur = q.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.dis;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!rangeCheck(nx, ny))
                    continue;

                int nDis = cur.dis + 1;

                if (map[nx][ny] == 0) { // 빈 칸
                    if (!cur.wallBreak && !visited[nx][ny][0]) { // 벽 부순 적 없으면
                        q.offer(new Coord(nx, ny, nDis, false));
                        visited[nx][ny][0] = true;
                    } else if (cur.wallBreak && !visited[nx][ny][1]) { // 벽 부순 적 있으면
                        q.offer(new Coord(nx, ny, nDis, true));
                        visited[nx][ny][1] = true;
                    }
                } else if (map[nx][ny] == 1) { // 벽
                    if (!cur.wallBreak && !visited[nx][ny][1]) { // 벽 부순 적 없으면 부수기
                        q.offer(new Coord(nx, ny, nDis, true));
                        visited[nx][ny][1] = true;
                    }
                }

            }
        }

        return -1;
    }

    static boolean rangeCheck(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m)
            return true;
        return false;
    }
}
