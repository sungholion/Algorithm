import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static char[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int normal, abnormal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        vis = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(vis[i][j]) continue;
                if(map[i][j] == 'R'){
                    normal++;
                    bfs(i, j, 'R', false);
                }
                else if(map[i][j] == 'G'){
                    normal++;
                    bfs(i, j, 'G', false);
                } else if(map[i][j] == 'B'){
                    normal++;
                    bfs(i, j, 'B', false);
                }
            }
        }

        vis = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(vis[i][j]) continue;
                if(map[i][j] == 'R' || map[i][j] == 'G'){
                    abnormal++;
                    bfs(i, j, 'R', true);
                } else if(map[i][j] == 'B'){
                    abnormal++;
                    bfs(i, j, 'B', true);
                }
            }
        }

        System.out.println(normal + " " + abnormal);
    }

    private static void bfs(int x, int y, char color, boolean mode){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        vis[x][y] = true;
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(vis[nx][ny]) continue;
                if(!mode){  // 정상
                    if(map[nx][ny] != color) continue;
                } else {    //적록색약
                    if(map[nx][ny] == 'B'){ // 만약에 B인데 B가 안나오면 안됌
                        if(color != 'B') continue;
                    } else{ // 만약 B가 아닌데 B가 나오면 안됌
                        if(color == 'B') continue;
                    }
                }
                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}