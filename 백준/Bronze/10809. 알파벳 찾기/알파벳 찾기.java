import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int[] alpa = new int[26];
        for(int i=0; i<alpa.length; i++) {
            alpa[i] = -1;
        }

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if(alpa[idx] == -1) alpa[idx] = i;
        }

        for(int i=0; i<alpa.length; i++) {
            sb.append(alpa[i]).append(" ");
        }
        System.out.println(sb.toString());

    }
}
