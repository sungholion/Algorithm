import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int res1 = a * (b % 10);
        int res2 = a * ((b % 100) / 10);
        int res3 = a * (b/100);
        int res4 = res1 + (10 * res2) + (100 * res3);

        bw.write(res1 + "\n");
        bw.write(res2 + "\n");
        bw.write(res3 + "\n");
        bw.write(res4 + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
