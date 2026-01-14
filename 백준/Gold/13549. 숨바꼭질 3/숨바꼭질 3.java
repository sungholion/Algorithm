import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;
    static final int INF = 1000000000;

    static class State implements Comparable<State> {
        int x;
        int t;
        State(int x, int t) {
            this.x = x;
            this.t = t;
        }
        @Override
        public int compareTo(State o) {
            return Integer.compare(this.t, o.t);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, INF);
        dist[N] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(N, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.t != dist[cur.x]) continue;
            if (cur.x == K) break;

            int nx = cur.x * 2;
            if (nx <= MAX && cur.t < dist[nx]) {
                dist[nx] = cur.t;
                pq.offer(new State(nx, dist[nx]));
            }

            nx = cur.x - 1;
            if (nx >= 0 && cur.t + 1 < dist[nx]) {
                dist[nx] = cur.t + 1;
                pq.offer(new State(nx, dist[nx]));
            }

            nx = cur.x + 1;
            if (nx <= MAX && cur.t + 1 < dist[nx]) {
                dist[nx] = cur.t + 1;
                pq.offer(new State(nx, dist[nx]));
            }
        }

        System.out.println(dist[K]);
    }
}
