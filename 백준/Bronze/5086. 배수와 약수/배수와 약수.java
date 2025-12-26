import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if(num1 == 0 && num2 == 0) break;

            if(num1 > num2 && num1 % num2 == 0) sb.append("multiple").append("\n");
            else if(num2 > num1 && num2 % num1 == 0) sb.append("factor").append("\n");
            else sb.append("neither").append("\n");

        }
        System.out.print(sb.toString());
    }
}