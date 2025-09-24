import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dist;
    static char[][] map;
    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < M; j++) map[i][j] = line.charAt(j);
        }

        System.out.println(bfs());
    }

    static int bfs() {
        dist = new int[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        dist[0][0] = 1;               
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == N - 1 && c == M - 1) return dist[r][c]; 

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == '0') continue;          
                if (dist[nr][nc] != 0) continue;             
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return -1; 
    }
}
