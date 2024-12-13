import java.io.*;
import java.util.*;

class Coord{
    int z;
    int x;
    int y;
    int time;

    public Coord(int z, int x, int y, int time){
        this.z = z;
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main{

    static int l, r, c;
    static char[][][] map;
    static boolean[][][] vis;
    static int dz[] = {-1, 1, 0, 0, 0, 0};
    static int dx[] = {0, 0, -1, 1, 0, 0};
    static int dy[] = {0, 0, 0, 0, -1, 1};
    static Coord start;
    static Coord end;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0){
                break;
            }

            map = new char[l][r][c];
            vis = new boolean[l][r][c];

            for(int i=0; i<l; i++){
                for(int j=0; j<r; j++){
                    String temp = br.readLine();
                    for(int k=0; k<c; k++){
                        map[i][j][k] = temp.charAt(k);
                        if(map[i][j][k] == 'S'){
                            start = new Coord(i, j, k, 0);
                        } else if(map[i][j][k] == 'E'){
                            end = new Coord(i, j, k, 0);
                        }
                    }
                }
                String changeLine = br.readLine();
            }

            ans = bfs(start);

            if(ans == -1){
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in " + ans + " minute(s).\n");
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(Coord start){
        Queue<Coord> q = new ArrayDeque<>();
        vis[start.z][start.x][start.y] = true;
        q.offer(start);

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<6; i++){
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nz < 0 || nx < 0 || ny < 0 || nz >= l || nx >= r || ny >= c || vis[nz][nx][ny] || map[nz][nx][ny] == '#'){
                    continue;
                }

                vis[nz][nx][ny] = true;
                ans++;
                q.offer(new Coord(nz, nx, ny, cur.time + 1));

                if(map[nz][nx][ny] == 'E'){
                    return cur.time + 1;
                }


            }
        }

        return -1;
    }

}