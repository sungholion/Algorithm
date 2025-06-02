import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 총 사람 수

        int[] tSize = new int[6];
        st = new StringTokenizer(br.readLine());    // 티셔츠 사이즈별 수요
        for(int i=0; i<tSize.length; i++){
            tSize[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());    // 한번에 구매하는 묶음
        int T = Integer.parseInt(st.nextToken());   // 티셔츠
        int P = Integer.parseInt(st.nextToken());   // 펜

        int T_sum = 0;
        int P_sum = 0;
        int P_remain = 0;
        for(int i = 0; i<tSize.length; i++){
            T_sum += tSize[i] / T;
            if(tSize[i] % T != 0)
                T_sum++;
        }

        P_sum = N / P;
        P_remain = N % P;

        sb.append(T_sum).append("\n").append(P_sum).append(" ").append(P_remain);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}