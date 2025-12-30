import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N == 0 || M == 0){
                sb.append("0\n");
                continue;
            }
            sb.append(combination(N, M)).append("\n");
        }
        System.out.print(sb);
    }
    static BigInteger combination(int n, int m) {
        BigInteger result = BigInteger.ONE;
        for(int i = 0; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(m-i));
            result = result.divide(BigInteger.valueOf(i+1));
        }
        return result;
    }
}