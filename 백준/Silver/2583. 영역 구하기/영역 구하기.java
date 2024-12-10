import java.io.*;
import java.util.*;

class Coord{
    int y;
    int x;

    public Coord(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class Main{
    static int m, n, k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int kc=0; kc<k; kc++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = y1; i < y2; i++){
                for(int j = x1; j < x2; j++){
                    map[i][j] = -1;
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] != -1 && !visited[i][j]){
                    cnt++;
                    bfs(new Coord(i, j));
                }
            }
        }

        Collections.sort(list);

        bw.write(cnt + "\n");
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i) + " ");
        }
        bw.flush();
        bw.close();
        br.close();

//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    static void bfs(Coord start){
        Queue<Coord> q = new ArrayDeque<>();

        visited[start.y][start.x] = true;
        int width = 1;
        q.offer(start);

        while(!q.isEmpty()){
            Coord cur = q.poll();

            for(int i=0; i<4; i++){
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= m || nx >= n || map[ny][nx] == -1 || visited[ny][nx]){
                    continue;
                }

                width++;
                visited[ny][nx] = true;
                q.offer(new Coord(ny, nx));

            }
        }

        list.add(width);

    }
}