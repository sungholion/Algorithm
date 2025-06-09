import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[10001];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        for(int i = 2; i <= N; i++)
            dp[i] = dp[i - 2].add(dp[i - 1]);

        sb.append(dp[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}