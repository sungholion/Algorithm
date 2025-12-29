import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int A2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B1 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        int lcm = getLCM(A2, B2);
        A1 = A1 * (lcm / A2);
        B1 = B1 * (lcm / B2);
        int sum1 = A1 + B1;
        int sum2 = lcm;
        int gcd = getGCD(sum1, sum2);
        sum1 /= gcd;
        sum2 /= gcd;

        sb.append(sum1).append(" ").append(sum2).append("\n");

        System.out.print(sb);
    }
    static int getGCD(int a, int b) {
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }

        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }
}