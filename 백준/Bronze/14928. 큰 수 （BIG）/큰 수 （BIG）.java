import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        long remain = 0;
        for(int i = 0; i < str.length(); i++) {
            remain = (remain * 10 + (str.charAt(i) - '0')) % 20000303;
        }

        sb.append(remain);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }



}
