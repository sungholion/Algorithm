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

    static int h,w;
    static char[][] map;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Coord> fire;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fire = new ArrayDeque<>();

            Coord start = new Coord(-1, -1);
            for(int i=0; i<h; i++){
                String temp = br.readLine();
                for(int j=0; j<w; j++){
                    map[i][j] = temp.charAt(j);
                    if(map[i][j] == '@'){
                        start = new Coord(i, j);
                    }
                    else if(map[i][j] == '*'){
                        fire.offer(new Coord(i, j));
                    }
                }
            }

            bfs(start);

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(Coord start){
        Queue<Coord> q = new ArrayDeque<>();

        vis = new boolean[h][w];
        vis[start.x][start.y] = true;
        q.offer(new Coord(-1, -1)); // 불 먼저 이동시키는 플래
        q.offer(start);
        int time = -1;  // 불이 먼저 움직여야 하므로, 불이 움직이는 건 시간으로 안 침

        while(!q.isEmpty()){
            Coord cur = q.poll();

            if(cur.x == -1 && cur.y == -1){
                burn();

                if(!q.isEmpty()){
                    q.offer(cur);   // 아직 상근이가 이동 중이라면, 불 옮겨붙기 다음에 한번 더 해야
                }
                time++;
                continue;
            }

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w ){
                    sb.append((time+1) + "\n");
                    return;
                }

                if(map[nx][ny] == '.' && !vis[nx][ny]){
                    vis[nx][ny] = true;
                    q.offer(new Coord(nx, ny));
                }

            }
        }
        sb.append("IMPOSSIBLE\n");
    }

    private static void burn(){
        int size = fire.size(); // 불 1개당 1번만 옮겨붙어야 하므로

        for(int s=0; s<size; s++){
            Coord cur = fire.poll();

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < h && ny < w && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                    fire.offer(new Coord(nx, ny));
                    map[nx][ny] = '*';
                }

            }
        }
    }

}