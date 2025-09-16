import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int remain = N % H;
            int share = N / H;

            if(remain == 0){
                sb.append(H);
            } else {
                share++;
                sb.append(remain);
            }

            if(share < 10) sb.append("0");
            sb.append(share);
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
