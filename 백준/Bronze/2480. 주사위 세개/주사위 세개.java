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

        if(A == B && B == C){
            sb.append(10000 + (A * 1000));
        } else if(A == B){
            sb.append(1000 + (A * 100));
        } else if(A == C){
            sb.append(1000 + (A * 100));
        } else if(B == C){
            sb.append(1000 + (B * 100));
        } else{
            int max = 0;
            if(A > max) max = A;
            if(B > max) max = B;
            if(C > max) max = C;
            sb.append(max * 100);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}