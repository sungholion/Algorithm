import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int total = 0;
        int exp = N.length() - 1;
        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            int num = -1;
            if(!Character.isDigit(c)){
                num = c - 'A' + 10;
            } else {
                num = c - '0';
            }
            total += (int)Math.pow(B, exp) * num;
            exp--;
        }
        System.out.println(total);

    }
}