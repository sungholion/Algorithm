import java.io.*;
import java.util.*;

class Coord{
    int x;
    int y;

    Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            vis = new boolean[N][M];
            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1 && !vis[i][j]){
                        cnt++;
                        bfs(new int[]{i, j});
                    }
                }
            }
            sb.append(cnt).append("\n");
            cnt = 0;
        }
        System.out.print(sb.toString());
    }
    static void bfs(int[] point){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(point);
        vis[point[0]][point[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                if(map[nx][ny] == 1 && !vis[nx][ny]){
                    q.offer(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
        }
    }
}
