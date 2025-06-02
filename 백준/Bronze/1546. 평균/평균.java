import java.io.*;
import java.util.*;


public class Main {
    static final int MOD = 1234567891;
    static final int R = 31;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num > M){
                M = num;
            }
            score[i] = num;
        }

        double sum = 0;
        for(int x : score){
            sum += x / (double) M * 100;
        }

        sb.append(sum / N);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}