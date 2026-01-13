import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        parent = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(1); 

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) sb.append(parent[i]).append('\n');
        System.out.print(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : tree[node]) {
            if (!visited[next]) {
                parent[next] = node;
                dfs(next);
            }
        }
    }
}
