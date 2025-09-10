import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] w = new int[N];
        int[] h = new int[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            h[i] = Integer.parseInt(st.nextToken());
        }

        int[] rank = new int[N];
        for(int i = 0; i < N; i++) {
            rank[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(w[j] > w[i] && h[j] > h[i]) {
                    rank[i]++;
                }
            }
        }

        for(int r : rank)
            sb.append(r).append(" ");

        System.out.println(sb.toString());
    }
}