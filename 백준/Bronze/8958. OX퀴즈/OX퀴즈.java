import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'O'){
                    cnt++;
                    sum += cnt;
                } else{
                    cnt = 0;
                }
            }
            bw.write(sum + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
