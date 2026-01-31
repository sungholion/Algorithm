import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        N = 1000 - N;
        int cnt = 0;

        cnt += N / 500;
        N %= 500;
        cnt += N / 100;
        N %= 100;
        cnt += N / 50;
        N %= 50;
        cnt += N / 10;
        N %= 10;
        cnt += N / 5;
        N %= 5;
        cnt += N;
        sb.append(cnt);

        System.out.print(sb);
    }
}
