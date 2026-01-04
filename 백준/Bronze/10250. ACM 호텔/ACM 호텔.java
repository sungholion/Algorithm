import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor = N % H;
            int room = N / H + 1;
            if(floor == 0) {
                floor = H;
                room--;
            }

            sb.append(floor);
            if(room < 10) sb.append("0");
            sb.append(room).append("\n");

        }
        System.out.print(sb);


    }
}
