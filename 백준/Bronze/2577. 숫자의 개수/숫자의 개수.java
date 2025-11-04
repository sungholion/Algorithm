import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        long res = A * B * C;
        int[] arr = new int[10];

        String str = String.valueOf(res);
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int x = c - '0';
            arr[x]++;
        }

        for(int x : arr)
            System.out.println(x);

    }
}
