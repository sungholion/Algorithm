import java.io.*;
import java.util.*;

public class Main{
    static class Edge{
        int to;
        int cost;

        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node{
        int v;
        int dist;

        Node(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
    }

    static int n, m, r;
    static int[] items;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, l));
            graph[b].add(new Edge(a, l));
        }

        int ans = 0;

        for(int node = 1; node <= n; node++){
            int[] dist = dijkstra(node);

            int sum = 0;
            for(int i = 1; i <= n; i++){
                if(dist[i] <= m) sum += items[i];
            }
            ans = Math.max(ans, sum);
        }
        System.out.print(ans);

    }

    static int[] dijkstra(int node){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Node(node, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.dist > dist[cur.v]) continue;

            for(Edge e : graph[cur.v]){
                int next = e.to;
                int nd = cur.dist + e.cost;

                if(nd < dist[next]){
                    dist[next] = nd;
                    pq.offer(new Node(next, nd));
                }
            }
        }
        return dist;
    }
}