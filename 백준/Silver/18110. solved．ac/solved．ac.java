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
        for(int i=0; i<N; i++)
            score[i] = Integer.parseInt(br.readLine());
        Arrays.sort(score);

        int exception = (int)Math.round((double) N * 0.15);
        int sum = 0;
        for(int i = exception; i < N - exception; i++)
            sum += score[i];
        int res = (int)Math.round((double)sum/(N-(exception*2)));

        sb.append(res);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}