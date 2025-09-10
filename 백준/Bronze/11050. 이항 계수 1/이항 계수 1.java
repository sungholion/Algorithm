import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = fact(N) / (fact(K) * fact(N - K));
        System.out.println(ans);
    }

    static int fact(int x) {
        int r = 1;
        for (int i = 2; i <= x; i++) r *= i;
        return r;
    }
}