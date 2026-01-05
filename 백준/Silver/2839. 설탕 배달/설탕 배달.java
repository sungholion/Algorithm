import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        while(true) {
            if(N % 5 == 0){
                ans += N / 5;
                System.out.println(ans);
                return;
            }
            N-= 3;
            ans++;
            if(N < 0){
                System.out.println(-1);
                return;
            }
        }
    }

}
