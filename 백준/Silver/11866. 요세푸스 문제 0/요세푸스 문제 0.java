import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        sb.append("<");

        Queue<Integer> q = new LinkedList<>();
        for(int i =1 ; i<=N; i++) q.offer(i);

        while(!q.isEmpty()) {
            for(int i=0; i<K-1; i++) q.offer(q.poll());
            sb.append(q.poll());
            if(!q.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb);
    }
}

