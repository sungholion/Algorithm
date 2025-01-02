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
    static int m, n, k;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int total;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[m][n];
        vis = new boolean[m][n];
        
        for(int kc = 0; kc < k; kc++){
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            for(int i = startX; i < endX; i++){
                for(int j = startY; j < endY; j++){
                    map[i][j] = 1;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0 && !vis[i][j]){
                    total++;
                    bfs(new Coord(i, j));
                }
            }
        }

        sb.append(total).append("\n");

        Collections.sort(list);
        for(int area : list){
            sb.append(area).append(" ");
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
        int area = 1;

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || vis[nx][ny] || map[nx][ny] == 1){
                    continue;
                }

                area++;
                vis[nx][ny] = true;
                q.offer(new Coord(nx, ny));
            }
        }
        list.add(area);
    }

}