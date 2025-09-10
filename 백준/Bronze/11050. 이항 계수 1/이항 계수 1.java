import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] C = new int[N + 1][N + 1];

        for (int n = 0; n <= N; n++) {
            C[n][0] = C[n][n] = 1;           // 양 끝은 1
            for (int k = 1; k < n; k++) {
                C[n][k] = C[n - 1][k - 1] + C[n - 1][k];
            }
        }

        System.out.println(C[N][K]);
    }

}