import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] students = new int[7][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            students[Y][S]++;
        }

        int ans = 0;
        for(int i = 1; i <= 6; i++){
            for(int j = 0; j < 2; j++){
                ans += (students[i][j]) / K;
                if(students[i][j] % K != 0) ans++;
            }
        }

        sb.append(ans);
        System.out.print(sb);
    }
}
