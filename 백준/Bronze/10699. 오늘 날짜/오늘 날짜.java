import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        LocalDate now = LocalDate.now();
        sb.append(now);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
