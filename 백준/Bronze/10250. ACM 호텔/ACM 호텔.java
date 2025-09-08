import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int Y = N % H;
            if(Y == 0) Y = H;

            int X = N / H;
            if (N % H != 0) X++;

            sb.append(Y * 100 + X).append("\n");
        }
        System.out.println(sb);
    }
}