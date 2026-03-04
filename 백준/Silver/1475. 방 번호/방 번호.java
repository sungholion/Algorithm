import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] freq = new int[10];
        for(int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - '0']++;
        }
        int sixNine = freq[6] + freq[9];
        freq[6] = (sixNine + 1) / 2;
        freq[9] = 0;
        
        int ans = -1;
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > ans) ans = freq[i];
        }
        sb.append(ans);
        System.out.print(sb);
    }
}
