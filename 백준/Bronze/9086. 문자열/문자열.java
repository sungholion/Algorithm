import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            int idx = str.length() - 1;
            sb.append(str.charAt(0)).append(str.charAt(idx)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
