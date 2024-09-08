import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        a = String.valueOf(a.charAt(2) + "" + a.charAt(1) + a.charAt(0));
        b = String.valueOf(b.charAt(2) + "" + b.charAt(1) + b.charAt(0));

        if(Integer.parseInt(a) > Integer.parseInt(b)) {
            bw.write(a);
        } else {
            bw.write(b);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
