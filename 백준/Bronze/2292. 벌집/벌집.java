import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int add = 1;
        int cnt = 1;    // 1번방도 count
        int line = 1;

        while (add < N) {
            cnt++;
            add += 6 * line;
            line++;
        }

        sb.append(cnt);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}