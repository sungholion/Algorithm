import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] t = new int[6];
        for(int i = 0; i < 6; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int needT = 0;
        int needP = 0;
        int needPremain = 0;

        for(int i = 0; i < t.length; i++) {
            needT += t[i] / T;
            if(t[i] % T != 0) needT++;
        }
        needP += N / P;
        needPremain += N % P;

        sb.append(needT).append("\n").append(needP).append(" ").append(needPremain).append("\n");
        System.out.println(sb.toString());
    }
}
