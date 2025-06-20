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

        sb.append(makeOne(N, 0));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int makeOne(int N, int cnt) {
        if (N < 2) {
            return cnt;
        }
        return Math.min(makeOne(N / 2, cnt + 1 + (N % 2)), makeOne(N / 3, cnt + 1 + (N % 3)));
    }

}
