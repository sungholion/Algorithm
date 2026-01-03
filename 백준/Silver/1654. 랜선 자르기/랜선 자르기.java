import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lines = new int[K];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < K; i++){
            lines[i] = Integer.parseInt(br.readLine());
            if(lines[i] > max) max = lines[i];
        }

        long left = 1;
        long right = max;
        long ans = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long cnt = 0;

            for(int i = 0; i < K; i++){
                cnt += lines[i] / mid;
            }

            if(cnt >= N){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);

    }
}