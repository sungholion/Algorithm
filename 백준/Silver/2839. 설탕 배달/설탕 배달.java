import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(true){
            if(N % 5 == 0){
                cnt += N / 5;
                System.out.print(cnt);
                break;
            }
            N -= 3;
            cnt++;

            if(N < 0){
                System.out.println(-1);
                break;
            }
        }
    }
}