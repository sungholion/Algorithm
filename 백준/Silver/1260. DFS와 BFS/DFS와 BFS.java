import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, v;
    static int[][] g;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        g = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            g[v1][v2] = g[v2][v1] = 1;
        }
        dfs(v);
        sb.append("\n");

        visited = new boolean[n+1];
        bfs(v);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int v){
        visited[v] = true;
        sb.append(v).append(" ");
        for(int i = 1; i<=n; i++){
            if(g[v][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            v = q.poll();
            sb.append(v).append(" ");
            for(int i = 1; i<=n; i++){
                if(g[v][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
