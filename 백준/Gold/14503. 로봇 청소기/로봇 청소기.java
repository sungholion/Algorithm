import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	int d;	// 방향. 0 : 북 / 1 : 동 / 2 : 남 / 3 : 서
	
	Point(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
public class Main{
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int cleanCnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());    // map의 크기 n * m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());    // 시작 위치 r,c 시작 방향 d
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


        for(int i=0; i<n; i++) {    // map 정보
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Point(r,c,d));

        sb.append(cleanCnt + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            Point cur = q.poll();

            // 1. 현재 칸이 아직 청소되지 않은 경우 현재 칸을 청소한다.
            if(map[cur.x][cur.y] == 0 && !visited[cur.x][cur.y]) {
                visited[cur.x][cur.y] = true;
                cleanCnt++;
            }

            boolean cleaned = false; // 청소 여부를 판단하기 위한 변수
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[(cur.d + 3 - i) % 4]; // 현재 방향의 왼쪽부터 탐색
                int ny = cur.y + dy[(cur.d + 3 - i) % 4];

                if(rangeCheck(nx, ny)) { // 청소할 공간이 있으면 청소하고 다음 칸으로 이동
                    q.offer(new Point(nx, ny, (cur.d + 3 - i) % 4));
                    cleaned = true;
                    break;
                }
            }

            if(!cleaned) { // 네 방향 모두 청소가 이미 되어있거나 벽인 경우
                int bx = cur.x + dx[(cur.d + 2) % 4]; // 후진할 위치
                int by = cur.y + dy[(cur.d + 2) % 4];
                if(map[bx][by] == 0) // 후진할 곳이 벽이 아니면 후진
                    q.offer(new Point(bx, by, cur.d));
            }
        }
    }

    static boolean rangeCheck(int x, int y) {
        if(x >=0 && x < n && y >= 0 && y < m && map[x][y] == 0 && !visited[x][y])
            return true;
        return false;
    }
}
