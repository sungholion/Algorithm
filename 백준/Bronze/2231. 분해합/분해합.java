import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int digits = String.valueOf(N).length();
        int start = Math.max(1, N - 9 * digits); // 탐색 시작점 최적화

        int ans = 0;
        for(int i = start; i<N; i++){
            int sum = 0;
            int x = i;
            sum+= x;

            while(x!=0){
                sum += x % 10;
                x/= 10;
            }

            if(sum == N){
                ans = i;
                break;
            }

        }
        sb.append(ans).append("\n");
        System.out.println(sb.toString());
    }
}