import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        int[] ways = new int[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        dist[N] = 0;
        ways[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (dist[K] != -1 && dist[cur] > dist[K]) continue;

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for (int next : nexts) {
                if (next < 0 || next > MAX) continue;

                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    ways[next] = ways[cur];
                    q.offer(next);
                }
                else if (dist[next] == dist[cur] + 1) {
                    ways[next] += ways[cur];
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(ways[K]);
    }
}
