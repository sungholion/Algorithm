import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (N-- > 0) {
            String s = br.readLine();
            boolean[] alpabet = new boolean[26];
            boolean flag = true;
            for (int i = 0; i < s.length()-1; i++) {
                char c = s.charAt(i);
                char c2 = s.charAt(i + 1);

                alpabet[c-'a'] = true;
                if((c2 != c) && (alpabet[c2-'a'])) {
                    flag = false;
                    break;
                }
            }

            if(flag)
                cnt++;

        }

        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}