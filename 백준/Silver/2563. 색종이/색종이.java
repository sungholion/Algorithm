import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] ans = new int[101][101];
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i = x; i < x + 10; i++){
                for(int j = y; j < y + 10; j++){
                    ans[i][j] = 1;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(ans[i][j] == 1) res++;
            }
        }
        System.out.println(res);
    }
}