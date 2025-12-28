import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = 0, idx = 0;
        for(int i = 0; i< 3; i++){
            String str = br.readLine();
            if(Character.isDigit(str.charAt(0))){
                num = Integer.parseInt(str);
                idx = i;
                break;
            }
        }
        int answer = num + (3-idx);

        if(answer % 3 == 0 && answer % 5 == 0){
            sb.append("FizzBuzz");
        } else if(answer % 3 == 0 && answer % 5 != 0){
            sb.append("Fizz");
        } else if(answer % 3 != 0 && answer % 5 == 0){
            sb.append("Buzz");
        } else{
            sb.append(answer);
        }

        System.out.print(sb.toString());
    }
}
