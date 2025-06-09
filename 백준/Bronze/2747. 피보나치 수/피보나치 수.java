import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static long[] arr = new long[46];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = 1;

        sb.append(fibonacci(N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long fibonacci(int N) {
        if (N == 0) return arr[0];
        if (N == 1) return arr[1];
        else{
            for (int i = 2; i <= N; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[N];
        }


    }
}