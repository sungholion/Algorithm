import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] vis;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        vis = new boolean[N][M];
        int sx = -1, sy = -1;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'I') { sx = i; sy = j; }
            }
        }

        int ans = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        vis[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (map[x][y] == 'P') ans++;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx<0||ny<0||nx>=N||ny>=M) continue;
                if (vis[nx][ny] || map[nx][ny]=='X') continue;
                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        System.out.print(ans == 0 ? "TT" : ans);
    }
}
