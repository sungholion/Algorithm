import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        int[] sum = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                sum[i] += time[j];
            }
        }

        int ans = 0;
        for(int x : sum)
            ans += x;

        sb.append(ans).append("\n");

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}