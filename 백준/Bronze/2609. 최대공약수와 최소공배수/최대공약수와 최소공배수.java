import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(gcd(A, B));
        System.out.println(lcd(A, B));
    }
    static int gcd(int a, int b) {
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }

        int temp = 0;
        while(b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
    static int lcd(int a, int b) {
        return a * b / gcd(a, b);
    }
}
