import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            for(int k = 1; k < T - i; k++) sb.append(" ");
            for(int j=0; j <= i; j++) sb.append("*");
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}