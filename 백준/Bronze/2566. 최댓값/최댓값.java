import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = 9;

        int[][] arr = new int[n][n];
        int max = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > max){
                    max = arr[i][j];
                    maxRow = i + 1;
                    maxCol = j + 1;
                }
            }
        }

        sb.append(max).append("\n");
        sb.append(maxRow).append(" ").append(maxCol).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}