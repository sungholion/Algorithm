import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += str.charAt(i) - '0';
        }

        sb.append(sum);
        System.out.println(sb);
    }
}