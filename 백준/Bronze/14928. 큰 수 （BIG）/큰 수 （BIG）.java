import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int mod = 20000303;
        long cur = 0;

        for (int i = 0; i < n.length(); i++) {
            cur = (cur * 10 + (n.charAt(i) - '0')) % mod;
        }

        System.out.println(cur);
    }
}