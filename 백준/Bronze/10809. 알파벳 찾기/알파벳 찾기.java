import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        int[] alphabet = new int[26];
        for(int i = 0; i < alphabet.length; i++){
            alphabet[i] = -1;
        }

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            int idx = c - 'a';

            if(alphabet[idx] == -1)
                alphabet[idx] = i;
        }

        for(int x : alphabet)
            bw.write(x + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
