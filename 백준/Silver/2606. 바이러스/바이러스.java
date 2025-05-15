import java.io.*;
import java.util.*;


public class Main {
    static int cnt;
    static int[][] arr;
    static boolean[] vis;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        vis = new boolean[n+1];
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1][v2] = arr[v2][v1] = 1;
        }

        bfs(1);
        System.out.println(cnt - 1);
    }

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;
        cnt++;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=1; i<=n; i++){
                if(arr[cur][i] == 1 && !vis[i]){
                    vis[i] = true;
                    q.offer(i);
                    cnt++;
                }
            }
        }
    }
}
