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
    static int L, R, C;
    static char[][][] map;
    static int[][][] vis;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Coord start;
    static Coord end;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0){
                break;
            }

            map = new char[L][R][C];
            vis = new int[L][R][C];

            for(int l=0; l<L; l++){
                for(int r=0; r<R; r++){
                    String temp = br.readLine();
                    for(int c=0; c<C; c++){
                        map[l][r][c] = temp.charAt(c);
                        if(map[l][r][c] == 'S'){
                            start = new Coord(l, r, c);
                        } else if(map[l][r][c] == 'E'){
                            end = new Coord(l, r, c);
                        }
                    }
                }
                br.readLine();
            }

            int ans = bfs();
            if(ans == -1){
                sb.append("Trapped!\n");
            } else{
                sb.append("Escaped in ").append(ans).append(" minute(s).\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        Queue<Coord> q = new ArrayDeque<>();
        q.offer(start);
        vis[start.x][start.y][start.z] = 1; // 구분을 위함. 나중에 -1

        while(!q.isEmpty()){
            Coord cur = q.poll();

            if((cur.x == end.x) && (cur.y == end.y) && (cur.z == end.z)){
                return vis[cur.x][cur.y][cur.z] - 1;
            }

            for(int i=0; i<6; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= L || ny >= R || nz >= C || map[nx][ny][nz] == '#' || vis[nx][ny][nz] != 0){
                    continue;
                }

                vis[nx][ny][nz] = vis[cur.x][cur.y][cur.z] + 1;
                q.offer(new Coord(nx, ny, nz));
            }
        }
        return -1;
    }

}