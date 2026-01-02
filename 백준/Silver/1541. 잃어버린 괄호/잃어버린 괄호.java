import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int num = 0;
        boolean minus = false;
        int res = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                if (minus) res -= num;
                else res += num;
                num = 0;
                if(c == '-') minus = true;
            }
        }

        if(minus) res -= num;
        else res += num;
        sb.append(res);
        System.out.print(sb);
    }
}