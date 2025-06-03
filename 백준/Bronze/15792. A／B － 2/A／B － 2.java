import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        sb.append(A/B).append(".");
        A %= B;

        for(int i = 0; i <= 1000; i++){
            A *= 10;
            sb.append(A/B);
            A %= B;
            if(A == 0)
                break;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}