import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        int MAX = 40;
        int[] zero = new int[MAX + 1];
        int[] one  = new int[MAX + 1];

        zero[0] = 1; one[0] = 0;
        zero[1] = 0; one[1] = 1;

        for (int i = 2; i <= MAX; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i]  = one[i - 1]  + one[i - 2];
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(zero[n]).append(' ').append(one[n]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
