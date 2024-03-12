import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N+1];
        int sum[] = new int[N+1];

        for(int i=1; i<=N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        sum[1] = arr[1];

        int result = sum[1];

        for(int i=2; i<=N; i++) {
            sum[i] = arr[i];

            for(int j=1; j<i; j++) {
                if(arr[i] > arr[j])
                    sum[i] = Math.max(sum[i], sum[j] + arr[i]);
            }

            result = Math.max(result, sum[i]);
        }

        System.out.println(result);
    }
}