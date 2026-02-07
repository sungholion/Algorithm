import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, w;
        Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -t));
            }

            long[] dist = new long[N + 1];
            Arrays.fill(dist, 0L);

            boolean negCycle = false;
            for (int i = 1; i <= N; i++) {
                boolean updated = false;
                for (Edge ed : edges) {
                    if (dist[ed.to] > dist[ed.from] + ed.w) {
                        dist[ed.to] = dist[ed.from] + ed.w;
                        updated = true;
                        if (i == N) {
                            negCycle = true;
                            break;
                        }
                    }
                }
                if (negCycle) break;
                if (!updated) break;
            }

            sb.append(negCycle ? "YES" : "NO").append('\n');
        }

        System.out.print(sb.toString());
    }
}
