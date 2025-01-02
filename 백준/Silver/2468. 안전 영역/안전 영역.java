import java.io.*;
import java.util.*;

class Coord{
    int x;
    int y;

    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int n;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxH = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxH){
                    maxH = map[i][j];
                }
            }
        }

        int maxCnt = 0;
        for(int h = 0; h <= maxH; h++){
            vis = new boolean[n][n];
            int cnt = 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] > h &&  !vis[i][j]){
                        cnt++;
                        bfs(new Coord(i, j), h);
                    }
                }
            }

            if(cnt > maxCnt){
                maxCnt = cnt;
            }

        }

        sb.append(maxCnt).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Coord start, int h){
        Queue<Coord> q = new ArrayDeque<>();

        vis[start.x][start.y] = true;
        q.offer(start);

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n || vis[nx][ny] || map[nx][ny] <= h){
                    continue;
                }

                vis[nx][ny] = true;
                q.offer(new Coord(nx, ny));
            }
        }
    }

}