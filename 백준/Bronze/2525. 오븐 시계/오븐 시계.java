import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        m += n;

        int plusH = m / 60;
        m -= plusH * 60;

        h += plusH;

        if(h >= 24) h-= 24;

        bw.write(h + " " + m + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
