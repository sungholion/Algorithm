import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int money = Integer.parseInt(br.readLine());

            sb.append(money/25).append(" ");
            money %= 25;
            sb.append(money/10).append(" ");
            money %= 10;
            sb.append(money/5).append(" ");
            money %= 5;
            sb.append(money/1).append(" ");
            money %= 1;
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}