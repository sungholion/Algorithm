import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;
        int cnt = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : list[cur]) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

}
