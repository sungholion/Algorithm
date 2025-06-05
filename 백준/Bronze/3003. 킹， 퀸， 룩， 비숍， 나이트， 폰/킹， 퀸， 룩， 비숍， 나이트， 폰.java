import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] ans = new int []{1, 1, 2, 2, 2, 8};

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++)
            sb.append(ans[i] - Integer.parseInt(st.nextToken())).append(' ');

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}