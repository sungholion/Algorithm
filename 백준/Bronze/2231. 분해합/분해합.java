import java.io.*;
import java.util.*;


public class Main {
    static final int MOD = 1234567891;
    static final int R = 31;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            int num = i;
            int sum = i;
            while(num != 0){
                sum += num % 10;
                num /= 10;
            }

            if(sum == N){
                sb.append(i);
                break;
            }

            if(i == N){
                sb.append(0);
                break;
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}