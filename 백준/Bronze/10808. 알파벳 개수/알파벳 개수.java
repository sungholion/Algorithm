import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int[] alpa = new int[26];

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int num = ch - 'a';
            alpa[num]++;
        }

        for(int i = 0; i < 26; i++) {
            sb.append(alpa[i] + " ");
        }
        System.out.println(sb);

    }
}
