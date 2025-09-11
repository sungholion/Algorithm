import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            q.offer(i);
        
        while(q.size() > 1){
            q.poll();
            q.offer(q.poll());
        }

        sb.append(q.poll());
        System.out.println(sb);
    }
}
