import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for(int j = 0; j < N - i; j++)
                sb.append(' ');
            for(int j = 0; j < (2 * i - 1); j++)
                    sb.append('*');
            sb.append('\n');
        }

        for (int i = N - 1; i >= 1; i--) {
            for(int j = 0; j < N - i; j++)
                sb.append(' ');
            for(int j = 0; j < (2 * i - 1); j++)
                sb.append('*');
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}