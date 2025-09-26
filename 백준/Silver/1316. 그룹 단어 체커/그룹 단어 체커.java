import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(N-- > 0) {
            String str = br.readLine();
            int l = str.length();
            boolean[] vis = new boolean[26];
            boolean isGroup = true;
            vis[str.charAt(0) - 'a'] = true;
            for(int i=1; i<l; i++) {
                char c = str.charAt(i);
                if(c != str.charAt(i-1) && vis[c-'a']) {
                    isGroup = false;
                    break;
                }
                vis[c-'a'] = true;
            }
            if(isGroup) cnt++;
        }

        System.out.println(cnt);
    }
}

