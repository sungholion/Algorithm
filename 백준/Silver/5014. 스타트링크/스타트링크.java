import java.io.*;
import java.util.*;

public class Main{

    static int f, s, g, u, d; // f : 총 층 수, s : 현재 층 수, g : 목표 층 수, u : 위 층으로 몇 칸, d : 아래층으로 몇 칸
    static int[] map;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[f+1];

        bfs(s);
        if(map[g] != -1){
            bw.write(map[g] - 1 + "\n");
        }
        else{
            bw.write("use the stairs" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x){
        Queue<Integer> q = new ArrayDeque<>();
        map[x] = cnt;

        q.offer(x);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == g){
                return;
            }

            if((cur + u) <= f && map[cur + u] == 0){
                map[cur+u] = map[cur] + 1;
                q.offer(cur+u);
            }

            if((cur - d) > 0 && map[cur-d] == 0){
                map[cur-d] = map[cur] + 1;
                q.offer(cur-d);
            }
        }

        map[g] = -1;
    }

}