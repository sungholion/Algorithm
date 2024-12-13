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

    static int n;
    static char[][] map;
    static boolean[][] vis;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int bfsCnt;
    static int redGreenBfsCnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        vis = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j]){
                    bfs(new Coord(i, j), map[i][j]);
                }
            }
        }

        vis = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j]){
                    redGreenBfs(new Coord(i, j), map[i][j]);

                }
            }
        }

        sb.append(bfsCnt + " " + redGreenBfsCnt + "\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static void bfs(Coord start, char color){
        Queue<Coord> q = new ArrayDeque<>();
        vis[start.x][start.y] = true;
        bfsCnt++;
        q.offer(start);

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n || vis[nx][ny]){
                    continue;
                }

                if(color == map[nx][ny]){
                    vis[nx][ny] = true;
                    q.offer(new Coord(nx, ny));
                }

            }
        }

    }

    private static void redGreenBfs(Coord start, char color){
        Queue<Coord> q = new ArrayDeque<>();
        vis[start.x][start.y] = true;
        redGreenBfsCnt++;
        q.offer(start);

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n || vis[nx][ny]){
                    continue;
                }

                if(color == 'R'){
                    if(map[nx][ny] == 'R' || map[nx][ny] == 'G'){
                        vis[nx][ny] = true;
                        q.offer(new Coord(nx, ny));
                    }
                } else if(color == 'G'){
                    if(map[nx][ny] == 'G' || map[nx][ny] == 'R'){
                        vis[nx][ny] = true;
                        q.offer(new Coord(nx, ny));
                    }
                } else if(color == 'B'){
                    if(map[nx][ny] == 'B'){
                        vis[nx][ny] = true;
                        q.offer(new Coord(nx, ny));
                    }
                }



            }
        }
    }
}