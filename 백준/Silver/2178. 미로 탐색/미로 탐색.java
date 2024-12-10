import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord{
    int x;
    int y;

    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int n,m;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];

        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(new Coord(0, 0));

        bw.write(visited[n-1][m-1] + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(Coord start){
        Queue<Coord> q = new ArrayDeque<>();
        visited[start.x][start.y] = 1;
        q.offer(start);

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] != 0 || map[nx][ny] != 1){
                    continue;
                }

                visited[nx][ny] = visited[cur.x][cur.y] + 1;
                q.offer(new Coord(nx, ny));

            }
        }

    }


}
