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

    static int r, c;
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

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        fire = new ArrayDeque<>();  // 이전 테스트케이스의 fire가 남아 있을 수 있으므로 초기화

        int startX = 0;
        int startY = 0;
        for(int i=0; i<r; i++){
            String temp = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'J'){   // 시작점
                    startX = i;
                    startY = j;
                }
                else if(map[i][j] == 'F'){  // 불 좌표를 큐에 추가
                    fire.offer(new Coord(i, j));
                }
            }

        }

        bfs(new Coord(startX, startY));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(Coord start){
        Queue<Coord> q = new ArrayDeque<>();    // 상근이를 담을 큐

        vis = new boolean[r][c];
        vis[start.x][start.y] = true;
        q.offer(new Coord(-1, -1)); // 불이 퍼지는 함수를 먼저 실행시키기 위한 플래그
        q.offer(start);
        int time = -1;  // 불이 먼저 움직여야 하므로, 불이 움직이는 건 시간으로 안 침

        while(!q.isEmpty()){
            Coord cur = q.poll();

            if(cur.x == -1 && cur.y == -1){
                burn();

                if(!q.isEmpty()){
                    q.offer(cur);   // 아직 상근이가 이동 중이라면, 불 옮겨붙기 다음에 한번 더 해야하므로
                }
                time++;
                continue;
            }

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c ){
                    time++; // 탈출 칸도 1초로 친다.
                    sb.append(time + "\n");
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

                if(nx >= 0 && ny >= 0 && nx < r && ny < c && (map[nx][ny] == '.' || map[nx][ny] == 'J')) {
                    fire.offer(new Coord(nx, ny));
                    map[nx][ny] = 'F';
                }

            }
        }
    }

}