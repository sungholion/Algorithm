import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = 0, lcm = 0;
        if(A > B){
            gcd = getGCD(A, B);
            lcm = getLCM(A, B);
        } else{
            gcd = getGCD(B, A);
            lcm = getLCM(B, A);
        }
        sb.append(gcd).append("\n").append(lcm).append("\n");
        System.out.println(sb.toString());
    }
    private static int getGCD(int a, int b) {
        while(b!=0){
            int r =  a % b;
            a = b;
            b = r;
        }
        return a;
    }
    private static int getLCM(int a, int b) {
        return (a*b) / getGCD(a, b);
    }
}