import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        sb.append(gcd(A,B)).append("\n");
        sb.append((A*B)/gcd(A,B));

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }
}
