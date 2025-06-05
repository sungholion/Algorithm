import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        str = str.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < str.length(); i++) {
            int val = map.get(str.charAt(i));
            if(val > max) {
                max = val;
            }
        }

        int cnt = 0;
        char maxChar = ' ';
        for(Character c : map.keySet()) {
            if(map.get(c) == max) {
                maxChar = c;
                cnt++;
            }
        }

        if(cnt > 1)
            sb.append('?');
        else
            sb.append(maxChar);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}