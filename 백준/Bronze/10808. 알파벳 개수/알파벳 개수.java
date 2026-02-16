import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int[] freq = new int[26];

        for(int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            sb.append(freq[i]).append(" ");
        }
        System.out.println(sb);

    }
}
