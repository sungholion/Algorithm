import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++)
            q.offer(i);

        sb.append("<");
        while(q.size() != 1) {
            for(int i = 0; i < K - 1; i++)
                q.offer(q.poll());
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll());
        sb.append(">");

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
