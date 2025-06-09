import java.io.*;
import java.util.*;


public class Main {
        static int[][] dp = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i < 41; i++) {
            for(int j = 0; j < 2; j++)
                dp[i][j] = -1;
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            fibonnaci(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] fibonnaci(int N) {
        if(dp[N][0] == -1 || dp[N][1] == -1) {
            dp[N][0] = fibonnaci(N-1)[0] + fibonnaci(N-2)[0];
            dp[N][1] = fibonnaci(N-1)[1] + fibonnaci(N-2)[1];
        }
        return dp[N];
    }

}