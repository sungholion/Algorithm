import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxWidth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && visited[i][j] == false){
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.print(maxWidth);
    }
    static void bfs(int x, int y){
        ArrayDeque<int[]> q =  new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int width = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny])
                    continue;
                if(map[nx][ny] == 1){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    width++;
                }
            }
        }

        if(width > maxWidth){
            maxWidth = width;
        }
    }
}
