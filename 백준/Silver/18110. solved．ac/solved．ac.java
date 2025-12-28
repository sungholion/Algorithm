import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int except = (int)Math.round(N * 0.15);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = except; i < arr.length - except; i++){
            sum += arr[i];
        }
        double avg = (double)sum / (N- 2 * except);
        sb.append(Math.round(avg));
        System.out.print(sb);
    }
}
