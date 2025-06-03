import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        N /= 4;

        while(N-- > 0)
            sb.append("long ");
        sb.append("int");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}