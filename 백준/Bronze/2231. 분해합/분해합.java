import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int res = 0;
        for(int i = 1; i <= N; i++) {
            int x = i;
            int total = x;
            while(x > 0){
                total += x % 10;
                x /= 10;
            }
            if(total == N){
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}
