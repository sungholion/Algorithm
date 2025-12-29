import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T  = Integer.parseInt(br.readLine());
        int res = 0;
        // 1. 빈도 체크, 출현 체크
        boolean isAnswer = true;
        for(int t = 0; t < T; t++) {
            String str = br.readLine();
            boolean[] vis = new boolean[26];
            isAnswer = true;
            for(int i = 0; i < str.length() - 1; i++) {
                char cur = str.charAt(i);
                char next = str.charAt(i + 1);
                if(cur != next && vis[next - 'a']){
                    isAnswer = false;
                    break;
                }
                vis[cur - 'a'] = true;
            }
            if(isAnswer) res++;
        }
        System.out.println(res);
    }
}