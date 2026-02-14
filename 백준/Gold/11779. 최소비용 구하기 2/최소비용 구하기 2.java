import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(e, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] prev = new int[N + 1];  

        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[1], b[1])
        );

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            long cost = cur[1];

            if (cost > dist[node]) continue;

            for (Edge next : graph[node]) {
                long nextCost = cost + next.cost;

                if (nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    prev[next.to] = node; 
                    pq.offer(new int[]{next.to, (int) nextCost});
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int cur = end;

        while (cur != 0) {
            stack.push(cur);
            cur = prev[cur];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");
        sb.append(stack.size()).append("\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
