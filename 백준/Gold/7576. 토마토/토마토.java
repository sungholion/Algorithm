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
    static int m, n;
    static int[][] map;
    static boolean[][] vis;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static Queue<Coord> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        vis = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1){
                    q.offer(new Coord(i, j));
                }
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(){

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] != 0){
                    continue;
                }

                map[nx][ny] = map[cur.x][cur.y] + 1;
                q.offer(new Coord(nx, ny));



            }
        }

        int max = Integer.MIN_VALUE;

        if(checkTomato()){
            return -1;
        } else{
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(max < map[i][j]){
                        max = map[i][j];
                    }
                }
            }
        }

        return max - 1;

    }

    private static boolean checkTomato(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }

}