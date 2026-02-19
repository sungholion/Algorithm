import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int[][] fireTime = new int[n][m];
        int[][] jihoonTime = new int[n][m];

        Queue<int[]> fireQueue = new ArrayDeque<>();
        Queue<int[]> jihoonQueue = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
                fireTime[i][j] = -1;
                jihoonTime[i][j] = -1;
                if(map[i][j] == 'F') {
                    fireQueue.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                } else if(map[i][j] == 'J') {
                    jihoonQueue.offer(new int[]{i, j});
                    jihoonTime[i][j] = 0;
                }
            }
        }

        while(!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;

                fireTime[nx][ny] = fireTime[cur[0]][cur[1]] + 1;
                fireQueue.offer(new int[]{nx, ny});
            }
        }

        while(!jihoonQueue.isEmpty()) {
            int[] cur = jihoonQueue.poll();
            int x = cur[0];
            int y = cur[1];

            if(x == 0 || x == n-1 || y == 0 || y == m-1){
                System.out.println(jihoonTime[x][y]+1);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == '#' || jihoonTime[nx][ny] != -1) continue;

                if(fireTime[nx][ny] != -1 && fireTime[nx][ny] <= jihoonTime[x][y]+1) continue;

                jihoonTime[nx][ny] = jihoonTime[x][y] + 1;
                jihoonQueue.offer(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
