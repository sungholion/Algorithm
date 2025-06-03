import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 1; i <= N; i++)
            q.add(i);

        while(true){
            if(q.size() == 1){
                sb.append(q.poll());
                break;
            }

            q.poll();
            q.add(q.poll());
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}