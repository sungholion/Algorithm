import java.io.*;
import java.sql.ClientInfoStatus;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> width = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int k = 0;  k < K; k++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = y1; i < y2; i++){
                for(int j = x1; j < x2; j++){
                    map[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        sb.append(cnt).append("\n");
        Collections.sort(width);
        for(int x : width){
            sb.append(x).append(" ");
        }

        System.out.print(sb);
    }
    static void bfs(int x, int y){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int curCnt = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    curCnt++;
                }
            }
        }
        width.add(curCnt);
    }
}