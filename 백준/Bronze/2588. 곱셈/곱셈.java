import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int res1 = A * (B % 10);
        int res2 = A * (B % 100 / 10);
        int res3 = A * (B / 100);
        int res4 = res1 + (10 * res2) + (100 * res3);

        sb.append(res1).append("\n").append(res2).append("\n").append(res3).append("\n").append(res4);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}