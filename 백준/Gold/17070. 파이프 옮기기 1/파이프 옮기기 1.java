import java.io.*;
import java.util.*;

public class Main {
    static long[][][] dp;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new long[N][N][3];
        
        dp[0][1][0] = 1;    // 초기 상태 : (0,0) - (0,1)이고 가로 상태
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1) continue;
                
                if (c - 1 >= 0) {
                    dp[r][c][0] += dp[r][c - 1][0];
                    dp[r][c][0] += dp[r][c - 1][2]; 
                }
                
                if (r - 1 >= 0) {
                    dp[r][c][1] += dp[r - 1][c][1]; 
                    dp[r][c][1] += dp[r - 1][c][2]; 
                }
                
                if (r - 1 >= 0 && c - 1 >= 0) {
                    if (map[r - 1][c] == 0 && map[r][c - 1] == 0) {
                        dp[r][c][2] += dp[r - 1][c - 1][0];
                        dp[r][c][2] += dp[r - 1][c - 1][1];
                        dp[r][c][2] += dp[r - 1][c - 1][2];
                    }
                }
            }
        }
        
        long answer = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        System.out.println(answer);
    }
}
