import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord {
    int z;
    int x;
    int y;

    public Coord(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, h;
    static int[][][] map;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static Queue<Coord> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        q.add(new Coord(i, j, k));
                    }
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        int days = -1; // 처음 상태를 0일로 시작하기 위해 -1로 초기화
        while (!q.isEmpty()) {
            int size = q.size(); // 같은 날에 익는 토마토들 처리를 위해 큐의 사이즈 저장
            for (int s = 0; s < size; s++) {
                Coord cur = q.poll();

                for (int i = 0; i < 6; i++) {
                    int nz = cur.z + dz[i];
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nz >= 0 && nz < h && nx >= 0 && nx < n && ny >= 0 && ny < m && map[nz][nx][ny] == 0) {
                        q.offer(new Coord(nz, nx, ny));
                        map[nz][nx][ny] = 1;
                    }
                }
            }
            days++; // 하루가 지남
        }

        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) {
                        return -1; // 익지 않은 토마토가 있는 경우
                    }
                }
            }
        }

        return days; // 모든 토마토가 익은 경우 걸린 날짜 반환
    }
}
