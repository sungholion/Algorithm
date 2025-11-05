import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x = 0;
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();
        if(str1.charAt(0) != 'F' && str1.charAt(0) != 'B'){
            x = Integer.parseInt(str1) + 3;
        } else if(str2.charAt(0) != 'F' && str2.charAt(0) != 'B'){
            x = Integer.parseInt(str2) + 2;
        } else if(str3.charAt(0) != 'F' && str3.charAt(0) != 'B'){
            x = Integer.parseInt(str3) + 1;
        }

        if((x % 3 == 0) && (x % 5 == 0)) sb.append("FizzBuzz");
        else if((x % 3 == 0) && (x % 5 != 0)) sb.append("Fizz");
        else if((x % 3 != 0) && (x % 5 == 0)) sb.append("Buzz");
        else sb.append(x);

        System.out.println(sb);

    }
}
