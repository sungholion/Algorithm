import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long max = arr[N - 1];

        long low = 0;
        long high = max;
        long ans = 0;
        while(low <= high){
            long mid = (low + high) / 2;
            long sum = 0;

            for(int i = 0; i < N; i++){
                if(arr[i] > mid) sum += arr[i] - mid;
            }

            if(sum >= M){
                ans = mid;
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        System.out.println(ans);

    }
}