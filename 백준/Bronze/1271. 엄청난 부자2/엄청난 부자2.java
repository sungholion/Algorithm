import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[][] maps;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n  = new BigInteger(st.nextToken());
        BigInteger m  = new BigInteger(st.nextToken());

        sb.append(n.divide(m)).append("\n");
        sb.append(n.mod(m)).append("\n");

        System.out.println(sb);
    }
}
