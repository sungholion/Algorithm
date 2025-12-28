import com.sun.jdi.IntegerValue;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i<= N; i++) q.addLast(i);
        while(q.size() > 1) {
            for(int i = 0; i< K-1; i++){
                q.addLast(q.pollFirst());
            }
            sb.append(q.pollFirst()).append(", ");
        }
        sb.append(q.pollFirst()).append(">");

        System.out.print(sb);
    }
}
