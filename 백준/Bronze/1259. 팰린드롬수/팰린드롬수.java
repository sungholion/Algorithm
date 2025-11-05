import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while(!(str = br.readLine()).equals("0")){
            boolean isPal = true;
            for(int i = 0; i < str.length() / 2; i++){
                if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                    isPal = false;
                    break;
                }
            }
            if(isPal) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb.toString());
    }
}
