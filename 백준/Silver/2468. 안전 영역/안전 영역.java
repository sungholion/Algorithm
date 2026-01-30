import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxH = Integer.MIN_VALUE;
    static int maxSafe = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num =  Integer.parseInt(st.nextToken());
                maxH = Math.max(num, maxH);
                map[i][j] = num;
            }
        }

        for(int h = 0; h <= maxH; h++){
            int cnt = 0;
            vis = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] > h && !vis[i][j]){
                        cnt++;
                        bfs(new int[]{i,j}, h);
                    }
                }
            }
            maxSafe = Math.max(maxSafe, cnt);
        }
        System.out.println(maxSafe);
    }

    static void bfs(int[] pos, int h){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{pos[0],pos[1]});
        vis[pos[0]][pos[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(map[nx][ny] > h && !vis[nx][ny]){
                    q.offer(new int[]{nx,ny});
                    vis[nx][ny] = true;
                }
            }
        }
    }
}
