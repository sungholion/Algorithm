import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String s = br.readLine();

            int cnt = 0;
            int score = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == 'O'){
                    cnt++;
                    score += cnt;
                }
                else if(c == 'X'){
                    cnt = 0;
                }
            }
            sb.append(score).append("\n");
        }
        System.out.println(sb.toString());
    }
}
