import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] idx = new int[26];
        for(int i = 0; i < idx.length; i++){
            idx[i] = -1;
        }
        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'a';
            if(idx[num] == -1) idx[num] = i;
        }

        for(int i = 0; i < 26; i++) {
            sb.append(idx[i]).append(" ");
        }
        System.out.println(sb);
    }
}
