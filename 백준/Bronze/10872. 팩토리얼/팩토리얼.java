import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append(factorial(n));
        System.out.print(sb);
    }
    static long factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n-1);
    }
}