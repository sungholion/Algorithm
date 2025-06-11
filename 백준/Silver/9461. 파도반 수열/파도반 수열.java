import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[101];

            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for(int i=4; i<101; i++)
                dp[i] = dp[i-2] + dp[i-3];
            sb.append(dp[N]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}