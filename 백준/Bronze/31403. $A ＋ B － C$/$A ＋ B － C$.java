import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        br.close();
        bw.write(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C)+"\n");
        bw.write(Integer.parseInt(A+B) - Integer.parseInt(C)+"\n");
        bw.flush();
        bw.close();
    }
}
