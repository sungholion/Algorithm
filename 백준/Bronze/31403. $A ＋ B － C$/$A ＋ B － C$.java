import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A  = Integer.parseInt(br.readLine());
        int B  = Integer.parseInt(br.readLine());
        int C  = Integer.parseInt(br.readLine());

        System.out.println(A + B - C);
        int temp = Integer.parseInt(A + "" + B);
        System.out.println(temp - C);
    }
}
