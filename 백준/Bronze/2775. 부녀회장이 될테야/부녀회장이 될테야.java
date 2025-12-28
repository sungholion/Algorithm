import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[15][15];
        for(int i = 1; i < 15; i++) arr[0][i] = i;  // 0층의 1호는 1명, 2호는 2명...
        for(int i = 1; i < 15; i++) arr[i][1] = 1;  // 모든 층의 1호는 다 1명
        for(int i = 1; i < 15; i++){
            for(int j = 1; j < 15; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        for(int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[k][n] + "\n");
        }
        System.out.print(sb.toString());
        /*
        층/호  1

        0     1    2   3   4   5   6   7   8
        1     1    3   6   10  15
        2     1    4   10  16
        3     1    5   15  31

         */
    }
}
