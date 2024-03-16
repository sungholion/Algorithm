import java.io.*;
import java.util.*;

public class Main {

    static int n, m, answer = Integer.MIN_VALUE;
    static int[] arr;

    public static void solution(int len, int start, int sum) {
        if (sum > m) return;
        if (len == 3) {
            answer = Math.max(sum, answer);
        }
        else {
            for (int i = start; i < n; i++) {
                solution(len+1, i+1, sum+arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0, 0);
        System.out.println(answer);
    }
}