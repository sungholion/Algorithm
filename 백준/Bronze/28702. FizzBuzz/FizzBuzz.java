import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      boolean flag = false;
      int num = 0;

      for(int i=0; i<3; i++){
         String s = br.readLine();

         char ch = s.charAt(0);

         if(ch != 'F' && ch != 'B'){
            flag = true;
            num = Integer.parseInt(s);
         }

         num++;
      }

      if(num % 3 == 0 && num % 5 == 0){
         bw.write("FizzBuzz\n");
      } else if(num % 3 == 0){
         bw.write("Fizz\n");
      } else if(num % 5 == 0){
         bw.write("Buzz\n");
      } else {
         bw.write(num + "\n");
      }

      bw.flush();
      bw.close();
      br.close();
   }
}