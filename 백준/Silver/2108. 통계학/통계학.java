import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        int[] cnt = new int[8001];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            cnt[arr[i] + 4000]++;
        }
        Arrays.sort(arr);
        sb.append(Math.round((double)sum / n)).append('\n');
        sb.append(arr[n/2]).append("\n");
        int maxFreq = 0;
        for (int c : cnt) 
            if (c > maxFreq) maxFreq = c;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (cnt[i] == maxFreq) list.add(i - 4000);
        }

        if (list.size() == 1) sb.append(list.get(0)).append('\n');
        else sb.append(list.get(1)).append('\n'); 
        
        sb.append(arr[n-1] - arr[0]).append("\n");

        System.out.println(sb);
    }
}
