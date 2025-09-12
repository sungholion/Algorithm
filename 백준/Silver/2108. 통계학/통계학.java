import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] cnt = new int[8001];

        long sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;

            sum += x; // 평균
            cnt[x + 4000]++; // 최빈
            if(x > max) max = x; // 최대
            if(x < min) min = x; // 최소
        }
        Arrays.sort(arr);

        int avg = (int)Math.round((double)sum / N); // 평균
        int mid = arr[arr.length / 2];  // 중앙값
        int maxFreq = 0;    //최빈값(두번째)
        for(int c : cnt) if(c > maxFreq) maxFreq = c;
        int freq = 0;
        boolean firstFound = false;
        for (int i = 0; i <= 8000; i++) {
            if (cnt[i] == maxFreq) {
                if (!firstFound) {
                    freq = i - 4000;     // 첫 번째 최빈값
                    firstFound = true;
                } else {
                    freq = i - 4000;     // 두 번째 최빈값
                    break;
                }
            }
        }
        int range = Math.abs(max - min);    // 범위

        sb.append(avg).append("\n").append(mid).append("\n").append(freq).append("\n").append(range);
        System.out.println(sb);
    }
}

