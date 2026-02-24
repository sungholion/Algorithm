import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int case1 = (int)(N * 0.78);
        int case2 = (int)(N - (N * 0.2 * 0.22));
        sb.append(case1).append(" ").append(case2);

        System.out.println(sb.toString());
    }
}
