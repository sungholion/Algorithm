import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] alpa = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alpa[c - 'a']++;
        }

        for(int x : alpa) {
            sb.append(x).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}