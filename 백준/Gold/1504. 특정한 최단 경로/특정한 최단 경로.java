import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int n;
        int cost;

        Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }
    }
    static ArrayList<Node>[] graph;
    static int N;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int distFrom1[] = dijkstra(1);
        int distFromV1[] = dijkstra(v1);
        int distFromV2[] = dijkstra(v2);

        long path1 = (long) distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        long path2 = (long) distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        long answer = Math.min(path1, path2);

        if(answer >= INF) System.out.print(-1);
        else System.out.print(answer);
    }

    static int[] dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.offer(new Node(start, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost != dist[cur.n]) continue;

            for(Node edge : graph[cur.n]){
                int next = edge.n;
                int nd = cur.cost + edge.cost;

                if(nd < dist[next]){
                    dist[next] = nd;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }


        return dist;
    }
}
