import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] vis;
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int sx, sy, tx, ty;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            vis = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            tx = Integer.parseInt(st.nextToken());
            ty = Integer.parseInt(st.nextToken());

            sb.append(bfs()).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs() {
        if (sx == tx && sy == ty) return 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[N][N];

        q.offer(new int[]{sx, sy});
        vis[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (vis[nx][ny]) continue;

                vis[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;

                if (nx == tx && ny == ty) return dist[nx][ny];

                q.offer(new int[]{nx, ny});
            }
        }
        return -1; // 여기까지는 사실상 안 옴
    }
}
