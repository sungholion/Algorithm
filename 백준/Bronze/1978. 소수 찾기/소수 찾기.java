import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num == 1)
                continue;

            boolean isPrime = true;
            for(int j = 2; j<num; j++){
                if(num % j == 0)
                    isPrime = false;
            }

            if(isPrime)
                cnt++;
        }

        sb.append(cnt).append("\n");
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}