import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        String str;
        while((str = br.readLine()) != null){
            sum += Integer.parseInt(str);
        }
        sb.append(sum);
        System.out.println(sb);
    }

}
