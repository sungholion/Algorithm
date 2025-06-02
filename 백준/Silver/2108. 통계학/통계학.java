import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];

        // 1. 산술평균
        int sum = 0;
        for(int i=0; i<N; i++){
            score[i] = Integer.parseInt(br.readLine());
            sum += score[i];
        }
        sb.append((int)Math.round((double)sum / N)).append("\n");

        // 2. 중앙값
        Arrays.sort(score);
        sb.append(score[N/2]).append("\n");

        // 3. 최빈값
        int[] cnt = new int[8001];
        for(int i=0; i<N; i++){
           cnt[score[i] + 4000]++;
        }

        int Max = 0;
        for(int i=0; i<8001; i++){
            if(cnt[i] > Max){
                Max = cnt[i];
            }
        }

        int mode = 0;
        boolean second = false;
        for(int i=0; i<8001; i++){
            if(cnt[i] == Max){
                if(!second){
                    mode = i - 4000;
                    second = true;
                } else{
                    mode = i - 4000;
                    break;
                }
            }

        }
        sb.append(mode).append("\n");

        // 4. 범위
        sb.append(score[N-1] - score[0]);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}