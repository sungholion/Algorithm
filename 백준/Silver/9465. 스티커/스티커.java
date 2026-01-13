import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][n];
            for (int r = 0; r < 2; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // dp[i][0] = 현재 아무것도 안 고른 경우 최대
            // dp[i][1] = 현재 위 스티커 고른 경우 최대
            // dp[i][2] = 현재 아래 스티커 고른 경우 최대
            int[][] dp = new int[n][3];

            dp[0][0] = 0;
            dp[0][1] = sticker[0][0];
            dp[0][2] = sticker[1][0];

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + sticker[0][i];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + sticker[1][i];
            }

            int answer = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
            sb.append(answer).append('\n');
        }

        System.out.print(sb.toString());
    }
}
