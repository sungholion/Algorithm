import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        //--------------------------------------------------------- 입력
        final int MOD = 1234567891;
        long ans = 0;
        long r = 1; 
        for (int i = 0; i < L; i++) {
            int n = (str.charAt(i) - 'a') + 1;
            ans = (ans + n * r) % MOD;
            r = (r * 31) % MOD; 
        }
        //--------------------------------------------------------- 풀이
        sb.append(ans).append("\n");
        System.out.println(sb.toString());
        //--------------------------------------------------------- 출력
    }
}