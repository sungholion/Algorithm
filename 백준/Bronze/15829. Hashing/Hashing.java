import java.io.*;
import java.util.*;


public class Main {
    static final int MOD = 1234567891;
    static final int R = 31;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long sum = 0;
        long pow = 1;

        for(int i=0; i<str.length(); i++){
            int a = str.charAt(i) - 'a' + 1;
            sum = (sum + a * pow) % MOD;
            pow = (pow * R) % MOD;
        }
        sb.append(sum);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}