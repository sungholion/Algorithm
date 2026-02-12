import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> fuze = new ArrayList<>();
    static int time;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int cheeseCnt = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheeseCnt++;
            }
        }

        // 가장자리는 0인 것이 보장되어 있으므로, (0,0)에서 시작해서 BFS로 외부공기(1개의 연결된 영역)을 구한다. 표시는 2로
        while(cheeseCnt > 0) {
            fuze.clear();
            resetExternalMark();
            bfsExternalAir();   // 외부 공기 구하고

            // 녹일 치즈 한번에 구하기
            for(int i = 1; i < N - 1; i++) {
                for(int j = 1; j < M - 1; j++) {
                    if(map[i][j] == 1) {
                        int cnt = 0;
                        for(int k = 0; k < 4; k++) {
                            if(map[i+dx[k]][j+dy[k]] == 2) cnt++;
                        }
                        if(cnt >= 2) fuze.add(new int[]{i, j});
                    }
                }
            }

            for(int[] f : fuze){
                cheeseCnt--;
                int x = f[0];
                int y = f[1];
                map[x][y] = 0;
            }
            time++;
        }
        System.out.println(time);
    }

    private static void bfsExternalAir() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

                if(map[nx][ny] == 0 || map[nx][ny] == 2){
                    visited[nx][ny] = true;
                    map[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }

            }
        }
    }

    static void resetExternalMark() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) map[i][j] = 0;
            }
        }
    }
}
