import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i<=N; i++){
            int sum = 0;
            int x = i;
            sum+= x;

            while(x!=0){
                sum += x % 10;
                x/= 10;
            }

            if(sum == N){
                sb.append(i).append("\n");
                break;
            }
            
            if(i == N){
                sb.append(0).append("\n");
                break;
            }
        }

        System.out.println(sb.toString());
    }
}