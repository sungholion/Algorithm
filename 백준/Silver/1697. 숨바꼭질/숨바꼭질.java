import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] map = new int[100001];
    static boolean[] vis = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        sb.append(map[k]).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        vis[n] = true;

        q.offer(n);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 3; i++) {
                if (cur == k) {
                    return;
                }

                if (i == 0 && (cur - 1) >= 0 && !vis[cur - 1]) {
                    map[cur - 1] = map[cur] + 1;
                    vis[cur - 1] = true;
                    q.offer(cur - 1);
                } else if (i == 1 && (cur + 1) < map.length && !vis[cur + 1]) {
                    map[cur + 1] = map[cur] + 1;
                    vis[cur + 1] = true;
                    q.offer(cur + 1);
                } else if (i == 2 && (cur * 2) < map.length && !vis[cur * 2]) {
                    map[cur * 2] = map[cur] + 1;
                    vis[cur * 2] = true;
                    q.offer(cur * 2);
                }

            }
        }
        return;
    }
}