import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] vis;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1][v2] = 1;
            arr[v2][v1] = 1;
        }

        vis = new boolean[n+1];
        dfs(v);
        System.out.println();

        vis = new boolean[n+1];
        bfs(v);

    }

    public static void dfs(int node){
        vis[node] = true;
        System.out.print(node + " ");

        for(int i=1; i<=n; i++){
            if(arr[node][i] == 1 && !vis[i]){
                dfs(i);
            }
        }

    }

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        vis[node] = true;
        q.offer(node);

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");

            for(int i=1; i<=n; i++){
                if(arr[cur][i] == 1 && !vis[i]){
                    vis[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
