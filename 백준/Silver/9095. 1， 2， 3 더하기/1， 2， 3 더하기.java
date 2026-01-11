import java.io.*;
import java.util.*;

public class Main {
    static int[] map = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for(int t = 0; t < T; t++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(dp[x]).append("\n");
        }
        System.out.println(sb);

        /*
        1 = 1
        2 = 1 + 1 / 2
        3 = 1 + 1 + 1 / 1 + 2 / 3

        4 = 1 + 1 + 1 + 1 / 1 + 1 + 2 / 1 + 2 + 1 / 2 + 1 + 1 / 2 + 2 / 1 + 3 / 3 + 1
         */

    }
}
