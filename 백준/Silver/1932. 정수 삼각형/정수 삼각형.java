import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] triangle;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];

            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] +
                        Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        int answer = 0;
        for (int j = 0; j < N; j++) {
            answer = Math.max(answer, dp[N-1][j]);
        }
        System.out.print(answer);
    }
}
