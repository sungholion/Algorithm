import java.io.*;
import java.util.*;

public class Main {
    static int[] map = new int[101];
    static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= 100; i++) map[i] = i;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start] = end;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start] = end;
        }

        sb.append(bfs());
        System.out.print(sb.toString());
    }

    static int bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});  // 현재 위치, 주사위 횟수
        visited[1] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int loc = cur[0];
            int cnt = cur[1];

            if(loc == 100) return cnt;

            for(int i = 1; i <= 6; i++){
                int next = loc + i;
                if(next > 100) continue;

                next = map[next];
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
        }
        return -1;
    }
}