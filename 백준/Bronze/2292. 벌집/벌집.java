import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(1);
            return;
        }
            int bee = 1;
            int ans = 1;
            while(bee < N){
                bee += 6 * ans;
                ans++;
            }
            sb.append(ans).append("\n");

        System.out.println(sb.toString());
    }
}