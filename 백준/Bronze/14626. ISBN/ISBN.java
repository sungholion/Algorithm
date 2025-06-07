import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int sum = 0;
        int multiplier = 1;
        int x_multiplier = 1;
        int m = str.charAt(str.length()-1) - '0';
        for(int i = 0; i < str.length()-1; i++) {
            char c = str.charAt(i);
            multiplier = (i % 2 == 0) ? 1 : 3;

            if(c != '*'){   // 훼손되지 않은 숫자는 규칙에 따라 더하기
                sum += (c - '0') * multiplier;
            } else {
               x_multiplier =  multiplier;
               continue;
            }
        }

        for(int i = 0; i < 10; i++){
            if((sum + (i * x_multiplier) + m) % 10 == 0)
                sb.append(i);
        }


        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}
