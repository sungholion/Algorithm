import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(br.readLine());
        long B = Long.parseLong(br.readLine());
        long C = Long.parseLong(br.readLine());

        long sum = A * B * C;
        String ans = String.valueOf(sum);
        int[] arr = new int[10];
        for(int i = 0; i < ans.length(); i++) {
            arr[ans.charAt(i) - '0']++;
        }

        for(int x : arr)
            sb.append(x).append("\n");
        System.out.print(sb);

    }
}
