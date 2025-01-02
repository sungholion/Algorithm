import java.io.*;
import java.util.*;

class Coord{
    int x;
    int y;
    int z;

    public Coord(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    static int M, N, H;
    static int[][][] map;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Coord> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[i][j][k] == 1){
                        q.offer(new Coord(i, j, k));
                    }
                }
            }
        }

        sb.append(bfs()).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<6; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= H || ny >= N || nz >= M || map[nx][ny][nz] != 0){
                    continue;
                }

                map[nx][ny][nz] = map[cur.x][cur.y][cur.z] + 1;
                q.offer(new Coord(nx, ny, nz));
            }

        }

        int max = Integer.MIN_VALUE;

        if(checkTomato()){
            return -1;
        } else{
            for(int i=0; i<H; i++){
                for(int j=0; j<N; j++){
                    for(int k=0; k<M; k++){
                        if(map[i][j][k] > max){
                            max = map[i][j][k];
                        }
                    }
                }
            }
        }

        return max - 1;
    }

    static boolean checkTomato(){
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[i][j][k] == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}