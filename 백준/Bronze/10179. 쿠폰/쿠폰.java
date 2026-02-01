import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            Double price = Double.parseDouble(br.readLine());
            price *= 0.8;
            sb.append("$").append(String.format("%.2f", price)).append('\n');
        }

        System.out.print(sb);
    }
}
