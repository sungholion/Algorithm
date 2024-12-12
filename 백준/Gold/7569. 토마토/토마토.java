import java.io.*;
import java.util.*;

class Coord{
    int z;
    int x;
    int y;

    public Coord(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int m, n, h;
    static int[][][] map;
    static boolean[][][] vis;
    static int dx[] = {-1, 1, 0, 0, 0, 0};
    static int dy[] = {0, 0, -1, 1, 0, 0};
    static int dz[] = {0, 0, 0, 0, -1, 1};
    static Queue<Coord> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        vis = new boolean[h][n][m];

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k] == 1){
                        q.offer(new Coord(i, j, k));
                    }
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

            for(int i=0; i<6; i++){
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nz < 0 || nx < 0 || ny < 0 || nz >= h || nx >= n || ny >= m || map[nz][nx][ny] != 0){
                    continue;
                }

                map[nz][nx][ny] = map[cur.z][cur.x][cur.y] + 1;
                q.offer(new Coord(nz, nx, ny));

            }
        }

        int max = Integer.MIN_VALUE;

        if(checkTomato()){
            return -1;
        } else{
            for(int i=0; i<h; i++){
                for(int j=0; j<n; j++){
                    for(int k=0; k<m; k++){
                        if(max < map[i][j][k]){
                            max = map[i][j][k];
                        }
                    }

                }
            }
        }

        return max - 1;

    }

    private static boolean checkTomato(){
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k] == 0){
                        return true;
                    }
                }

            }
        }
        return false;
    }

}