import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] g = new ArrayList[N+1];
        for (int i=1;i<=N;i++) g[i] = new ArrayList<>();
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b); g[b].add(a);
        }

        int bestNode = 1, bestSum = Integer.MAX_VALUE;
        int[] dist = new int[N+1];

        for (int s = 1; s <= N; s++) {
            Arrays.fill(dist, -1);
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offer(s); dist[s] = 0;
            int sum = 0;

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : g[cur]) {
                    if (dist[nxt] != -1) continue;
                    dist[nxt] = dist[cur] + 1;
                    sum += dist[nxt];
                    q.offer(nxt);
                }
            }
            if (sum < bestSum) {
                bestSum = sum;
                bestNode = s;
            }
        }
        System.out.print(bestNode);
    }
}
