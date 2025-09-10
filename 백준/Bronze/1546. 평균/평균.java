import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = -1;
        int[] scores = new int[N];
        double avg = 0.0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            scores[i] = x;
            if(x > M) M = x;
        }

        for(int num : scores)
            avg += ((double)num / M) * 100;

        avg /= N;
        sb.append(avg).append("\n");
        System.out.println(sb.toString());

    }
}