import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        if (str.equals("SONGDO")) {
            sb.append("HIGHSCHOOL");
        } else if (str.equals("CODE")) {
            sb.append("MASTER");
        } else if (str.equals("2023")) {
            sb.append("0611");
        } else if (str.equals("ALGORITHM")) {
            sb.append("CONTEST");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
