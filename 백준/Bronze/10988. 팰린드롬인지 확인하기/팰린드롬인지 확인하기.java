import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                flag = false;
                break;
            }
        }

        if(flag)
            sb.append(1);
        else
            sb.append(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}