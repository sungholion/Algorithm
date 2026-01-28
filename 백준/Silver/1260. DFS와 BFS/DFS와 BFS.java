import java.io.*;
import java.util.*;

class Main{
    static int N, M, V;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N+1];
        for(int i = 1; i <= N; i++)
            lists[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        for(int i = 1; i<=N; i++){
            Collections.sort(lists[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);

        System.out.print(sb);
    }

    static void dfs(int v){
        visited[v] = true;
        sb.append(v).append(" ");
        for(int next :  lists[v]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    static void bfs(int v){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(v);
        visited[v] = true;
        sb.append(v).append(" ");

        while(!q.isEmpty()){
            int cur =  q.poll();
            for(int next : lists[cur]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    sb.append(next).append(" ");
                }
            }
        }
    }
}
