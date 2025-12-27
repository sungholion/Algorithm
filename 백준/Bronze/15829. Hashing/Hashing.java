import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long hash = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int num = c - 'a' + 1;
            hash += num * (long)Math.pow(31, i) % 1234567891;
        }


        System.out.print(hash);
    }
}
