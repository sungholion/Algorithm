import java.io.*;
import java.util.*;


public class Main {
    static Integer[] dp;
    static int[] stair;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        stair = new int[n+1];
        for (int i = 1; i <= n; i++)
            stair[i] = Integer.parseInt(br.readLine());

        dp[0] = stair[0];
        dp[1] = stair[1];

        if(n >= 2)
            dp[2] = stair[1] + stair[2];

        sb.append(find(n)).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int N) {
        if(dp[N] == null) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + stair[N - 1]) + stair[N];
        }
        return dp[N];
    }

}
