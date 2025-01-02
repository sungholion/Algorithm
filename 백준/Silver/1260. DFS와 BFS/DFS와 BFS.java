import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[][] map;
    static boolean[]vis;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        vis = new boolean[N+1];
        dfs(V);

        sb.append("\n");

        vis = new boolean[N+1];
        bfs(V);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start){
        vis[start] = true;
        sb.append(start).append(" ");

        for(int i=1; i<=N; i++){
            if(map[start][i] == 1 && !vis[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        vis[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start).append(" ");

            for(int i=1; i<= N; i++){
                if(map[start][i] == 1 && !vis[i]){
                    q.offer(i);
                    vis[i] = true;
                }
            }
        }
    }

}