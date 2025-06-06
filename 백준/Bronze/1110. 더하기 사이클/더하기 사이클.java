import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int origin = N;
        int cnt = 0;

        do{
            cnt++;
            int n1 = N / 10;
            int n2 = N % 10;
            int sum = n1 + n2;
            N = (n2 * 10) + (sum % 10);
        } while(N != origin);

        sb.append(cnt);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}
