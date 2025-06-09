import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[91];
        dp[1] = 1;
        for(int i = 2; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        sb.append(dp[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}