import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        int ripedCnt = 0;
        int nonRipedCnt = 0;
        int noCnt = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                if(x == 1) {
                    ripedCnt++;
                    q.offer(new int[]{i, j});
                }
                else if(x == -1) noCnt++;
                else if(x == 0) nonRipedCnt++;
            }
        }

        if((ripedCnt + noCnt) == (N * M)){
            System.out.println("0");
            return;
        }

        int cnt = bfs();
        if(cnt == (nonRipedCnt)){
            int time = Integer.MIN_VALUE;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(visited[i][j] > time) time = visited[i][j];
                }
            }
            sb.append(time);
        } else {
            sb.append(-1);
        }

        System.out.print(sb.toString());
    }
    static int bfs() {
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0) continue;    // 맵 벗어낫는지, 이동할 수 있는 칸인지 체크
                if(visited[nx][ny] != 0) continue; // 이미 방문했는지 체크
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
                cnt++;
            }
        }
        return cnt;
    }
}