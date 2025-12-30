import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, n));
        /*
        1 2 3 4  5
        1 3 6 10 15
        2 4 8 16
         */
        System.out.print(sb);
    }
}