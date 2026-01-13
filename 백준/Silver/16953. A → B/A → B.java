import java.io.*;
import java.util.*;

class Node{
    long val;
    int cnt;

    Node(long val, int cnt){
        this.cnt = cnt;
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        sb.append(bfs(A, B));
        System.out.print(sb);
    }

    static int bfs(long A, long B) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(A,1));

        while(!q.isEmpty()){
            Node cur = q.poll();
            long val = cur.val;
            int cnt = cur.cnt;

            if(val == B) return cnt;

            long next1 = val * 2;
            if(next1 <= B){
                q.offer(new Node(next1,cnt+1));
            }
            long next2 = val * 10 + 1;
            if(next2 <= B){
                q.offer(new Node(next2,cnt+1));
            }
        }
        return -1;
    }
}
