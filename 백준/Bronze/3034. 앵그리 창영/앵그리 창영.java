import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n <= W) {
                sb.append("DA\n");
            }else if(n <= H) {
                sb.append("DA\n");
            }else if(n <= Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2))) {
                sb.append("DA\n");
            }else {
                sb.append("NE\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
