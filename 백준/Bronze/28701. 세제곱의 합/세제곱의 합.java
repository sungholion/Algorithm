import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        
        long s = n * (n + 1) / 2;
        
        System.out.println(s);
        System.out.println(s * s);
        System.out.println(s * s);
    }
}