import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int t = 0; t < M; t++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                bfs(i);
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.print(sb);
    }
    static void dfs(int v){
        visited[v] = true;
        sb.append(v).append(" ");

        for(int i = 1; i <= N; i++){
            if(map[v][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    static void bfs(int v){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[v] = true;
        q.offer(v);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i <= N; i++){
                if(map[cur][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

    }
}