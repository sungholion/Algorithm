import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<3; i++){
            String str = br.readLine();
            int num = 0;
            if(str.equals("Fizz") || str.equals("Buzz") || str.equals("FizzBuzz")){
                continue;
            } else {
                num = Integer.parseInt(str);
                num += 3 - i;

                if((num % 3 == 0) && (num % 5 == 0)){
                    sb.append("FizzBuzz");
                } else if((num % 3 == 0) && (num % 5 != 0)){
                    sb.append("Fizz");
                } else if((num % 3 !=0) && (num % 5 == 0)){
                    sb.append("Buzz");
                } else{
                    sb.append(num);
                }
                break;
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}