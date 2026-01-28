import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[101];
        dp[1] = 1; dp[2] = 1; dp[3] = 1;
        for(int i = 4; i <= 100; i++){
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        int T = Integer.parseInt(br.readLine());
        for(int i  = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        System.out.print(sb);
    }
}
