import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int temp = 0;
        if(Character.isDigit(str1.charAt(0))){
            temp = Integer.parseInt(str1) + 3;
        } else if(Character.isDigit(str2.charAt(0))){
            temp = Integer.parseInt(str2) + 2;
        } else if(Character.isDigit(str3.charAt(0))){
            temp = Integer.parseInt(str3) + 1;
        }

        if((temp % 3 == 0) && (temp % 5 == 0)){
            System.out.println("FizzBuzz");
        } else if((temp % 3 == 0) && (temp % 5 != 0)){
            System.out.println("Fizz");
        } else if((temp % 3 != 0) && (temp % 5 == 0)){
            System.out.println("Buzz");
        } else{
            System.out.println(temp);
        }

    }
}