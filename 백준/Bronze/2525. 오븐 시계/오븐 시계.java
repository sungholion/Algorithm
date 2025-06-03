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
        int C = Integer.parseInt(br.readLine());

        B += C;
        if(B >= 60){
            int plusA = (B / 60);
            A += plusA;
            B -= plusA * 60;
        }

        if(A >= 24)
            A -= 24;
        
        sb.append(A).append(" ").append(B);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}