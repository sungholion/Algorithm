import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int year = Integer.parseInt(br.readLine());
        sb.append(year - 543);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}