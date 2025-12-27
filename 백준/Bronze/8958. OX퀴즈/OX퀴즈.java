import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String str= br.readLine();
            int prefix = 0;
            int sum = 0;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == 'O'){
                    prefix++;
                    sum+= prefix;
                } else {
                    prefix = 0;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
