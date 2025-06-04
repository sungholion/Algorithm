import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++)
            coin[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        while(K != 0){
            for(int i = N-1; i >= 0; i--){
                int money = coin[i];

                if(money <= K){
                    cnt += K / money;
                    K %= money;
                }
            }
        }

        sb.append(cnt);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}