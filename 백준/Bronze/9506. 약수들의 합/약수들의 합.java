import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;

            if(isPerfect(n)){
                String temp = sb.toString();
                for(int i = 0; i < temp.length()-3; i++){
                    System.out.print(temp.charAt(i));
                }
                System.out.println();
            } else {
                sb = new StringBuilder();
                sb.append(n).append(" is NOT perfect.\n");
                System.out.print(sb);
            }
        }
    }

    static boolean isPerfect(int n){
        int sum = 0;
        sb.append(n).append(" = ");
        for(int i = 1; i < n; i++){
            if(n % i == 0){
                sum += i;
                sb.append(i).append(" + ");
            }
        }
        if(sum == n) return true;
        return false;
    }
}