import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String N = br.readLine();
            if(N.equals("0")) break;

            boolean isPalindrome = true;
            for(int i=0; i<N.length()/2; i++){
                if(N.charAt(i) != N.charAt(N.length()-1-i)){
                    isPalindrome = false;
                    break;
                }
            }
            if(isPalindrome) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.print(sb.toString());

    }
}
