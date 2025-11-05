import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());   // 층수
            int W = Integer.parseInt(st.nextToken());   // 방수
            int N = Integer.parseInt(st.nextToken());   // 몇번째 손
            int[][] hotel = new int[H][W];

            int floor = N % H;
            int room = N / H + 1;
            if(floor == 0) {
                floor = H;
                room -= 1;
            }
            sb.append(floor).append(String.format("%02d", room)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
