import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int rgb, nonRgb;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    nonRgb++;
                    bfs(new int[]{i, j}, map[i][j], true);
                }
            }

        }
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    rgb++;
                    bfs(new int[]{i, j}, map[i][j], false);
                }
            }
        }

        sb.append(nonRgb).append(" ").append(rgb).append("\n");
        System.out.print(sb.toString());
    }
    static void bfs(int[] point, char color, boolean isRgb) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[point[0]][point[1]] = true;
        q.offer(point);
        if(isRgb){  // 적록색약 아닐때
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(map[nx][ny] == color && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        } else {
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                    if((color == map[nx][ny]) || (color == 'R' && map[nx][ny] == 'G') || color == 'G' && map[nx][ny] == 'R'){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}