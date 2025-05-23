import java.awt.image.ImageProducer;
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
    static int[][] arr;
    static int[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        vis = new int[n][m];


        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(new Coord(0,0));
        System.out.println(vis[n-1][m-1]);

    }

    public static void bfs(Coord node){
        Queue<Coord> q = new LinkedList<>();
        q.offer(node);
        vis[node.x][node.y] = 1;

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || vis[nx][ny] != 0 || arr[nx][ny] != 1){
                    continue;
                }
                vis[nx][ny] = vis[cur.x][cur.y] + 1;
                q.offer(new Coord(nx, ny));
            }
        }
    }

}
