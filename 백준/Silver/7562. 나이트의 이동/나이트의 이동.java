import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord{
    int x;
    int y;

    public  Coord(int x, int y){
        this.x = x;
        this.y = y;
    }

}



public class Main{

    static int l;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-2, -2, -1, -1, 2, 2, 1, 1 };
    static int[] dy = {-1, 1, -2, 2, -1, 1, -2, 2 };
    static Coord start;
    static Coord target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc<t; tc++){
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            start = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            target = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int answer = bfs(start);

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(Coord start){
        Queue<Coord> q = new ArrayDeque<>();

        visited[start.x][start.y] = true;
        q.offer(start);

        while(!q.isEmpty()){
            Coord cur = q.poll();

            if(cur.x == target.x && cur.y == target.y){
                return map[cur.x][cur.y];
            }

            for(int i=0; i<8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= l || ny >= l || visited[nx][ny]){
                    continue;
                }

                visited[nx][ny] = true;
                map[nx][ny] = map[cur.x][cur.y] + 1;
                q.offer(new Coord(nx, ny));
            }
        }

        return -1;
    }


}