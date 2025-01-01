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
    static int n, m;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt;
    static int maxArea;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && !vis[i][j]){
                    cnt++;
                    int area = bfs(new Coord(i, j));
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }

        sb.append(cnt).append("\n").append(maxArea).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(Coord start){
        Queue<Coord> q = new ArrayDeque<>();

        vis[start.x][start.y] = true;
        q.offer(start);

        int area = 1;
        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0 || vis[nx][ny]){
                    continue;
                }

                area++;
                vis[nx][ny] = true;
                q.offer(new Coord(nx, ny));
            }
        }
        return area;
    }

}