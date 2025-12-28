import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            q.addLast(i);
        }
        while(q.size() > 1) {
            q.pollFirst();
            q.addLast(q.pollFirst());
        }
        sb.append(q.pollFirst());

        System.out.print(sb.toString());
    }

}
