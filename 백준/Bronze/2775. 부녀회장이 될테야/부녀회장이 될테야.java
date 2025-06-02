import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[][] apt = new int[15][15];

        for(int i = 0; i < 15; i++){
            apt[i][1] = 1;
            apt[0][i] = i;
        }

        for(int i = 1; i < 15; i++){
            for(int j = 2; j < 15; j++){
                apt[i][j] = apt[i][j-1] + apt[i-1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n]).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
