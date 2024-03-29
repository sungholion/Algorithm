import java.io.*;
import java.util.*;

class Coord {
    int x;
    int y;
    int dis;
    boolean canBreak;

    public Coord(int x, int y, int dis, boolean canBreak) {
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.canBreak = canBreak;
    }
}

public class Main {
    static int n, m;
    static int[][] map; // 맵. n x m. 인덱스 1부터 시작
    static boolean[][][] visited; // 방문 체크 배열. [x좌표][y좌표][벽1개 부수는/부수지 않는 경우. 1과 0으로 구분]
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1][2];	// [][][0] 벽을 부수지 않는 경우 방문 체크. 1은 부수는 경우

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j-1) - '0';
            }
        }

        int totalDis = bfs(new Coord(1, 1, 1, false));
        sb.append(totalDis);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(Coord coord) {
        Queue<Coord> q = new LinkedList<>();
        q.offer(coord);
        visited[1][1][0] = true;

        while (!q.isEmpty()) {
            Coord cur = q.poll();

            if (cur.x == n && cur.y == m) {
                return cur.dis;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!rangeCheck(nx, ny))		// map 벗어나는지 체크
                    continue;

                int nDis = cur.dis + 1;			// 칸 이동 횟수++

                if (map[nx][ny] == 0) { // 빈 칸
                    if (!cur.canBreak && !visited[nx][ny][0]) { // 벽 부순 적 없으면
                        q.offer(new Coord(nx, ny, nDis, false));
                        visited[nx][ny][0] = true;
                    } else if (cur.canBreak && !visited[nx][ny][1]) { // 벽 부순 적 있으면
                        q.offer(new Coord(nx, ny, nDis, true));
                        visited[nx][ny][1] = true;
                    }
                } else if (map[nx][ny] == 1) { // 벽
                    if (!cur.canBreak && !visited[nx][ny][1]) { // 벽 부순 적 없으면 부수기
                        q.offer(new Coord(nx, ny, nDis, true));
                        visited[nx][ny][1] = true;
                    }
                    // 벽 부순 적 있으면 못부수니까 넘어가기.
                } 

            }
        }

        return -1;
    }

    static boolean rangeCheck(int x, int y) {
        if (x >= 1 && y >= 1 && x <= n && y <= m)
            return true;
        return false;
    }
}
