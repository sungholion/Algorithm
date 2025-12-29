import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }
        int interval = 0;
        for(int i = 0; i < N - 1; i++) {
            int dis = trees[i + 1] - trees[i];
            interval = gcd(dis, interval);
        }
        sb.append((trees[N-1] - trees[0]) / interval + 1 - N);
        System.out.println(sb);
    }
    static int gcd(int a, int b) {
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}