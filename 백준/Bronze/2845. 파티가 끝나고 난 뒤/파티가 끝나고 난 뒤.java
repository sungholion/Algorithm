import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        long total = (long) L * P;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++){
            int x = Integer.parseInt(st.nextToken());
            sb.append(x - total).append(" ");
        }

        System.out.println(sb);
    }


}
