import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] g;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a); // 무방향
        }

        // 번호가 작은 것부터 방문
        for (int i = 1; i <= N; i++) Collections.sort(g[i]);

        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');

        Arrays.fill(visited, false);
        bfs(V);

        System.out.print(sb.toString());
    }

    static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');
        for (int nx : g[v]) {
            if (!visited[nx]) dfs(nx);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            sb.append(v).append(' ');
            for (int nx : g[v]) {
                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(nx);
                }
            }
        }
    }
}