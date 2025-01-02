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
    static int l;
    static int [][] map;
    static boolean [][] vis;
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {-1, 1, -1, 1, -2, 2, -2, 2};
    static Coord start;
    static Coord end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc<t; tc++){
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            vis = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            start = new Coord(startX, startY);

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            end = new Coord(endX, endY);

            sb.append(bfs()).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        Queue<Coord> q = new ArrayDeque<>();

        vis[start.x][start.y] = true;
        q.offer(start);

        while(!q.isEmpty()){
            Coord cur = q.poll();

            if((cur.x == end.x) && (cur.y == end.y)){
                return map[cur.x][cur.y];
            }

            for(int i=0; i<8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= l || ny >= l || vis[nx][ny]){
                    continue;
                }

                vis[nx][ny] = true;
                q.offer(new Coord(nx, ny));
                map[nx][ny] = map[cur.x][cur.y] + 1;
            }
        }

        return 0;
    }


}