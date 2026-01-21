import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int t = N / 5;
        if(N % 5 != 0) t++;
        sb.append(t);
        System.out.println(sb);
    }

}
