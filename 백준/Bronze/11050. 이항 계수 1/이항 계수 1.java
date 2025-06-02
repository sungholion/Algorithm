import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        sb.append(pascal(N, K)).append("\n");

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int pascal(int N, int K){
        if(N == K || K == 0) return 1;
        return pascal(N-1, K-1) + pascal(N-1, K);
    }
}
