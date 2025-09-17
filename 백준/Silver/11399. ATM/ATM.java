import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(P); 
        long total = 0;   
        long prefix = 0; 
        for (int x : P) {
            prefix += x;   
            total  += prefix;
        }

        System.out.println(total);
    }
}
