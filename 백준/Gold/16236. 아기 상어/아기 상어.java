import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int sharkEatCnt = 0;
    static int sharkR, sharkC;
    static int totalTime = 0;

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkR = i;
                    sharkC = j;
                    map[i][j] = 0; 
                }
            }
        }

        while (true) {
            int[] fish = bfs();
            if (fish == null) break; 

            int dist = fish[0];
            int r = fish[1];
            int c = fish[2];

            totalTime += dist;
            sharkEatCnt++;

            sharkR = r;
            sharkC = c;

            map[r][c] = 0;

            if (sharkEatCnt == sharkSize) {
                sharkSize++;
                sharkEatCnt = 0;
            }
        }

        System.out.println(totalTime);
    }

    static int[] bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sharkR, sharkC, 0});
        visited[sharkR][sharkC] = true;

        List<int[]> candidateFish = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (dist > minDist) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] > sharkSize) continue;

                visited[nr][nc] = true;

                if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
                    candidateFish.add(new int[]{dist + 1, nr, nc});
                    minDist = dist + 1;
                }
                queue.offer(new int[]{nr, nc, dist + 1});
            }
        }

        if (candidateFish.isEmpty()) return null;

        candidateFish.sort((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) return Integer.compare(a[2], b[2]);
                else return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        return candidateFish.get(0);
    }
}
