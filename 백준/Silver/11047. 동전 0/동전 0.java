import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] a = new long[N];
        for (int i = 0; i < N; i++) a[i] = Long.parseLong(br.readLine());

        long ans = 0;
        for (int i = N - 1; i >= 0 && K > 0; i--) {
            if (a[i] <= K) {
                ans += K / a[i];
                K %= a[i];
            }
        }
        System.out.println(ans);
    }
}
