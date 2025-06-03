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
        int C = Integer.parseInt(st.nextToken());

        int res1 = (A+B) % C;
        int res2 = ((A % C) + (B % C)) % C;
        int res3 = (A * B) % C;
        int res4 = ((A % C) * (B % C)) % C;
        sb.append(res1).append("\n").append(res2).append("\n").append(res3).append("\n").append(res4);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}