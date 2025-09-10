import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001]; 

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            count[x]++; 
        }

        for (int i = 1; i <= 10000; i++) {
            while (count[i]-- > 0) 
                sb.append(i).append('\n');
        }
        System.out.println(sb.toString());
    }
}