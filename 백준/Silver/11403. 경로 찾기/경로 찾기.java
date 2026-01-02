import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
    static void bfs(int i) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(i);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next = 0; next < N; next++){
                if(map[cur][next] == 1 && !visited[next]){
                    visited[next] = true;
                    map[i][next] = 1;
                    q.offer(next);
                }
            }
        }
    }
}