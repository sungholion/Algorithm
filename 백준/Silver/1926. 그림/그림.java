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

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int maxArea;
    static int area;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    area = 0;
                    area = dfs(new Coord(i, j));
                    maxArea = Math.max(maxArea, area);
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");
        bw.write(maxArea + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    static int dfs(Coord start) {
        visited[start.x][start.y] = true;

        area++;
        for(int i=0; i<4; i++) {
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) {
                continue;
            }

            dfs(new Coord(nx, ny));
        }

        return area;
    }
}
