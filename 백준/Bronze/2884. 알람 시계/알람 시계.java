import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        M -= 45;
        if(M < 0){
            M += 60;
            H -= 1;
        }

        if(H < 0)
            H += 24;

        sb.append(H).append(" ").append(M);
        System.out.println(sb);

    }
}