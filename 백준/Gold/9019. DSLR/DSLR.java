import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(bfs(A, B));
        }
    }

    static String bfs(int a, int b){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        int[] prev = new int[10000];
        char[] how = new char[10000];
        q.offer(a);
        visited[a] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == b) break;

            int d = D(cur);
            if(!visited[d]){
                visited[d] = true;
                prev[d] = cur;
                how[d] = 'D';
                q.offer(d);
            }

            int s = S(cur);
            if(!visited[s]){
                visited[s] = true;
                prev[s] = cur;
                how[s] = 'S';
                q.offer(s);
            }

            int l = L(cur);
            if(!visited[l]){
                visited[l] = true;
                prev[l] = cur;
                how[l] = 'L';
                q.offer(l);
            }

            int r = R(cur);
            if(!visited[r]){
                visited[r] = true;
                prev[r] = cur;
                how[r] = 'R';
                q.offer(r);
            }
        }

        StringBuilder sb = new StringBuilder();
        int cur = b;
        while(cur != a){
            sb.append(how[cur]);
            cur = prev[cur];
        }
        return sb.reverse().toString();
    }


    static int D(int n){
        return (n * 2) % 10000;
    }
    static int S(int n){
        return n == 0 ? 9999 : n - 1;
    }
    static int L(int n){
        return (n % 1000) * 10 + (n / 1000);
    }
    static int R(int n){
        return (n % 10) * 1000 + (n / 10);
    }
}