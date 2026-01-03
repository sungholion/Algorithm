import java.io.*;
import java.util.*;

class Point{
    int x;
    String order;

    Point(int x,String order){
        this.x=x;
        this.order=order;
    }
}

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
        ArrayDeque<Point> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        q.offer(new Point(a, ""));
        visited[a] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x == b) return cur.order;

            int d = D(cur.x);
            if(!visited[d]){
                visited[d] = true;
                q.offer(new Point(d, cur.order + "D"));
            }
            int s = S(cur.x);
            if(!visited[s]){
                visited[s] = true;
                q.offer(new Point(s, cur.order + "S"));
            }
            int l = L(cur.x);
            if(!visited[l]){
                visited[l] = true;
                q.offer(new Point(l, cur.order + "L"));
            }
            int r = R(cur.x);
            if(!visited[r]){
                visited[r] = true;
                q.offer(new Point(r, cur.order + "R"));
            }
        }
        return "";
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