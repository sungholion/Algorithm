import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty()){sb.append(0).append("\n");}
                else sb.append(pq.poll()).append("\n");
            }
            else pq.offer(x);
        }

        System.out.println(sb);
    }

}
