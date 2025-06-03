import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i])
                max = arr[i];
        }
        
        max++;  // max +1 (mid 0 방지)

        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (max + min) / 2;

            long cnt = 0;
            for (int i = 0; i < arr.length; i++)  // 구한 중간 길이로 몇개 나오는지
                cnt += (arr[i] / mid);

            if(cnt < N) // 요구한 개수보다 적으면 길이를 -
                max = mid;
            else        // 그 외에는 길이를 +
                min = mid + 1;
        }

        sb.append(min -1);  // 아까 +1 했으므로
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}