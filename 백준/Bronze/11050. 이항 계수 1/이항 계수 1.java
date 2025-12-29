import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        sb.append(factorial(N) / (factorial(K) * factorial(N-K)));
        System.out.print(sb.toString());
    }

    static long factorial(int x) {
        if(x <= 1) return 1;
        return x * factorial(x-1);
    }
}
