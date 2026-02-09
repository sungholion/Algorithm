import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        System.out.println(fib(n)[0]);
    }
    
    static long[] fib(long n) {
        if (n == 0) return new long[]{0, 1};

        long[] half = fib(n / 2);
        long a = half[0];
        long b = half[1];

        long t = (2 * b) % MOD;
        t = (t - a + MOD) % MOD;

        long c = (a * t) % MOD;
        long d = ((a * a) % MOD + (b * b) % MOD) % MOD;

        if (n % 2 == 0) return new long[]{c, d};
        return new long[]{d, (c + d) % MOD};
    }
}
