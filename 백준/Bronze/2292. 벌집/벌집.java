import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int cur = 1;
        while(N > cur){
            cur += 6 * cnt;
            cnt++;
        }
        sb.append(cnt);
        System.out.print(sb.toString());
    }
}