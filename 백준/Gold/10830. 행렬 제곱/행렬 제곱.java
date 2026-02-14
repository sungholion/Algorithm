import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long B;
    static int[][] A;
    static final int MOD = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = power(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int[][] power(int[][] matrix, long b) {

        if (b == 1) {
            return matrix;
        }

        int[][] half = power(matrix, b / 2);

        int[][] result = multiply(half, half);

        if (b % 2 == 1) {
            result = multiply(result, matrix);
        }

        return result;
    }

    static int[][] multiply(int[][] m1, int[][] m2) {

        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {          
            for (int j = 0; j < N; j++) {      
                for (int k = 0; k < N; k++) { 

                    result[i][j] += m1[i][k] * m2[k][j];
                    result[i][j] %= MOD;  
                }
            }
        }

        return result;
    }
}
