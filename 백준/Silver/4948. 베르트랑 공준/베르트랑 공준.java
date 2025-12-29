import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int cnt = 0;
            for(int i = n + 1; i <= 2 * n; i++){
                if(isPrime(i)) cnt++;
            }
            sb.append(cnt + "\n");
        }

        System.out.print(sb);
    }
    static boolean isPrime(int num) {
        if(num < 2) return false;
        if(num == 2 || num == 3) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        for(int i = 5; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

}