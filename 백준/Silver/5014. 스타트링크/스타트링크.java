import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[F+1];

        bfs();

        if(map[G] == 0){
            sb.append("use the stairs\n");
        } else{
            sb.append(map[G] - 1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        map[S] = 1;
        q.offer(S);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == G){
                return;
            }

            if((cur + U) <= F && map[cur+U] == 0){
                map[cur+U] = map[cur] + 1;
                q.offer(cur+U);
            }

            if((cur - D) >= 1 && map[cur-D] == 0){
                map[cur-D] = map[cur] + 1;
                q.offer(cur-D);
            }
        }
    }

}