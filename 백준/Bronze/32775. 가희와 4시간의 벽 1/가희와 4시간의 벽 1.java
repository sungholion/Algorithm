import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if(a > b)
            sb.append("flight");
        else
            sb.append("high speed rail");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
