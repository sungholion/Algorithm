import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
            return;
        }
        int[] map = new int[100001];
        boolean[] visited = new boolean[100001];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[N] = true;
        map[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for(int next : nexts){
                if(next < 0 || next > 100000) continue;
                if(!visited[next]){
                    visited[next] = true;
                    map[next] = map[cur] + 1;
                    q.offer(next);

                    if(next == K){
                        System.out.println(map[next]);
                        return;
                    }
                }
            }
        }
    }
}
