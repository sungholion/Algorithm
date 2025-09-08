import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(st.countTokens() + "\n");
        bw.flush();
    }
}
