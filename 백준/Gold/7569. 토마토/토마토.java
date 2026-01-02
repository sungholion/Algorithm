import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] map;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        visited = new int[H][N][M];

        int ripedCnt = 0; int nonRipedCnt = 0; int noCnt = 0;
        for(int h = 0; h < H; h++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    map[h][i][j] = x;
                    if(x == 1) {
                        ripedCnt++;
                        q.offer(new int[]{h, i, j});
                        visited[h][i][j] = 1;
                    }
                    else if(x == -1) noCnt++;
                    else if(x == 0) nonRipedCnt++;
                }
            }

        }

        if((ripedCnt + noCnt) == (H * N * M)){
            System.out.println("0");
            return;
        }

        bfs();
        int time = Integer.MIN_VALUE;
        for(int h = 0; h < H; h++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(visited[h][i][j] > time) time = visited[h][i][j];
                    if(map[h][i][j] == 0){
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        sb.append(time - 1);

        System.out.print(sb.toString());
    }
    static void bfs() {
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];
            for(int i = 0; i < 6; i++){
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if(map[nz][nx][ny] != 0) continue; // 이미 방문했는지, 안익은 토마토인지 체크
                visited[nz][nx][ny] = visited[cur[0]][cur[1]][cur[2]] + 1;
                map[nz][nx][ny] = 1;
                q.offer(new int[]{nz, nx, ny});
            }
        }
    }
}