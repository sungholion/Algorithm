import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1]; // 1-indexed
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        int answer = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);
            if (sum < minSum) {
                minSum = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next = 1; next <= N; next++) {
                if (map[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }
        return sum;
    }
}
