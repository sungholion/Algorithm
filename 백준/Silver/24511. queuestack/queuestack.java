import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] status = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            status[i] = Integer.parseInt(st.nextToken());   // 1이면 스택 0 이면 큐
        ArrayDeque<Integer> qstack = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(status[i] == 0) qstack.offerFirst(x);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            qstack.offerLast(x);
            sb.append(qstack.pollFirst()).append(" ");
        }


        System.out.print(sb);
    }
}