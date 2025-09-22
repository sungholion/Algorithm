import java.io.*;
import java.util.*;

public class Main {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); 
            int N = Integer.parseInt(st.nextToken()); 
            int K = Integer.parseInt(st.nextToken());

            boolean[][] grid = new boolean[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                grid[y][x] = true;
            }

            int count = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (grid[y][x] && !visited[y][x]) {
                        bfs(y, x, grid, visited, N, M);
                        count++;
                    }
                }
            }
            out.append(count).append('\n');
        }
        System.out.print(out);
    }

    static void bfs(int sy, int sx, boolean[][] grid, boolean[][] visited, int N, int M) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sy][sx] = true;
        q.offer(new int[]{sy, sx});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (!grid[ny][nx] || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }
    }
}
