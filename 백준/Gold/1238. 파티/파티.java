import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static final int INF = 1000000000;

    static int[] dijkstra(int start, List<Edge>[] graph) {
        int n = graph.length - 1;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1]) 
        );

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int v = cur[0];
            int d = cur[1];

            if (d != dist[v]) continue; 

            for (Edge e : graph[v]) {
                int nd = d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new int[]{e.to, nd});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N + 1];
        List<Edge>[] reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, t));
            reverseGraph[b].add(new Edge(a, t)); 
        }

        int[] fromX = dijkstra(X, graph);       
        int[] toX   = dijkstra(X, reverseGraph);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, fromX[i] + toX[i]);
        }

        System.out.println(ans);
    }
}
