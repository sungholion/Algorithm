import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            boolean isPrime = true;
            if(x == 1) continue;
            if(x == 2){
                cnt++;
                continue;
            }
            for(int j=2; j<x; j++){
                if(x % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)cnt++;
        }

        sb.append(cnt);
        System.out.println(sb.toString());
    }
}