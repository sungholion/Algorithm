import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            int A  = Integer.parseInt(st.nextToken());
            int B  = Integer.parseInt(st.nextToken());
            System.out.println(A + B);
        }
    }
}
