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

    static class State implements Comparable<State> {
        int node;
        long dist;
        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim()); 
        int M = Integer.parseInt(br.readLine().trim()); 

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
     
            if (cur.dist != dist[cur.node]) continue;

            if (cur.node == end) break;

            for (Edge e : graph[cur.node]) {
                long nextDist = cur.dist + e.cost;
                if (nextDist < dist[e.to]) {
                    dist[e.to] = nextDist;
                    pq.offer(new State(e.to, nextDist));
                }
            }
        }

        System.out.print(dist[end]);
    }
}
