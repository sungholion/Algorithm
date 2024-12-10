import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int n,k;
    static int[] map = new int[1000001];
    static boolean[] visited = new boolean[1000001];
    static int cnt = 1; // 0이면 map의 초기값과 구분할 수 없으므로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);

        bw.write(map[k] - 1 +"\n"); // map 초기값과 구분하기 위해 cnt를 1로 설정해줬으므로 빼주기
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();

        visited[start] = true;
        map[start] = cnt;

        q.offer(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=0; i<3; i++){
                if(cur == k){
                    return;
                }

                if(i == 0 && (cur-1) >= 0 && !visited[cur-1]){
                    map[cur-1] = map[cur] + 1;
                    visited[cur-1] = true;
                    q.offer(cur-1);
                }

                else if(i == 1 && (cur+1) < map.length && !visited[cur+1]){
                    map[cur+1] = map[cur] + 1;
                    visited[cur+1] = true;
                    q.offer(cur+1);
                }

                else if(i == 2 && (cur*2) < map.length && !visited[cur*2]){
                    map[cur*2] = map[cur] + 1;
                    visited[cur*2] = true;
                    q.offer(cur*2);
                }
            }
        }

        return;
    }

}