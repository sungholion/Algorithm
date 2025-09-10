import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[k+1][n+1];
            for(int i = 1; i <= n; i++) arr[0][i] = i;  // 0층 초기화
            for(int i = 1; i <= k; i++){
                for(int j = 1; j <= n; j++){
                    for(int l = 1; l <= j; l++){
                        arr[i][j] += arr[i-1][l];
                    }
                }
            }
            sb.append(arr[k][n]).append("\n");

        }
        System.out.println(sb.toString());
    }
}