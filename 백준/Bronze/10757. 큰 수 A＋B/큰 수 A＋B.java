import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        BigInteger a = new BigInteger(s[0]);
        BigInteger b = new BigInteger(s[1]);

        System.out.println(a.add(b));
    }
}