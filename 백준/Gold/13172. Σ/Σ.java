import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        long answer = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());

            long gcd = gcd(N, S);
            N /= gcd;
            S /= gcd;

            long inverse = pow(N, MOD - 2);

            long value = (S % MOD) * inverse % MOD;

            answer = (answer + value) % MOD;
        }

        System.out.println(answer);
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long pow(long a, long b) {
        long result = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) { 
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}
