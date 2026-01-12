import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp =  new long[101];
        dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2;
        for(int i = 6; i <= 100; i++) dp[i] = dp[i-2] + dp[i-3];
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int x = Integer.parseInt(br.readLine());
            sb.append(dp[x]).append("\n");
        }
        
        System.out.print(sb.toString());
    }

}
