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
    static int n, m, k;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            vis = new boolean[m][n];

            for(int kc = 0; kc < k; kc++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            cnt = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] == 1 && !vis[i][j]){
                        bfs(new Coord(i, j));
                    }
                }
            }
            sb.append(cnt).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Coord start){
        Queue<Coord> q = new ArrayDeque<>();

        vis[start.x][start.y] = true;
        q.offer(start);
        cnt++;
        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || vis[nx][ny] || map[nx][ny] != 1){
                    continue;
                }

                vis[nx][ny] = true;
                q.offer(new Coord(nx, ny));
            }
        }
    }

}