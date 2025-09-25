import java.io.*;
import java.util.*;

public class Main {
    static final int LIMIT = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N, K));
    }

    // 정석 BFS: dist로 방문+최단거리 관리, 큐는 ArrayDeque
    static int bfs(int start, int target) {
        if (start >= target) return start - target; // 뒤로만 가면 끝

        int[] dist = new int[LIMIT + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 1차원에서의 3가지 이동(상하좌우 대신)
            int[] nexts = {cur - 1, cur + 1, cur << 1};

            for (int nx : nexts) {
                if (nx < 0 || nx > LIMIT) continue;
                if (dist[nx] != -1) continue;    // 이미 방문(최단 확정)

                dist[nx] = dist[cur] + 1;
                if (nx == target) return dist[nx]; // 최초 도달 = 최단
                q.offer(nx);
            }
        }
        return dist[target]; // 이론상 도달 가능
    }
}
