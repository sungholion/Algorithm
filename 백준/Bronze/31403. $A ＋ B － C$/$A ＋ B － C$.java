import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int res1 = A + B - C;
        String temp = (A + "" + B);
        int res2 = Integer.parseInt(temp) - C;
        sb.append(res1 + "\n" + res2 + "\n");
        System.out.println(sb);
    }
}