import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(getLcm(A, B));
        }
    }
    private static int getGcd(int a, int b) {
        while(b!= 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    private static long getLcm(int a, int b) {
        return (a / getGcd(a, b)) * b;
    }
}

