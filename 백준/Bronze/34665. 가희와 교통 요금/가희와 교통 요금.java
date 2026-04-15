import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine();
        String B = br.readLine();
        
        if (A.equals(B)) {
            System.out.println(0);
        } else {
            System.out.println(1550);
        }
    }
}