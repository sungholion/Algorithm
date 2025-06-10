import java.io.*;
import java.util.*;


public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        sb.append(makeOne(N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int makeOne(int N) {
        if (dp[N] == null) {

            if (N % 6 == 0) {
                dp[N] = Math.min(makeOne(N - 1), Math.min(makeOne(N / 3), makeOne(N / 2))) + 1;
            }

            else if (N % 3 == 0) {
                dp[N] = Math.min(makeOne(N / 3), makeOne(N - 1)) + 1;
            }

            else if (N % 2 == 0) {
                dp[N] = Math.min(makeOne(N / 2), makeOne(N - 1)) + 1;
            }

            else {
                dp[N] = makeOne(N - 1) + 1;
            }
        }
        return dp[N];
    }

}
