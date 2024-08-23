import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      while (true) {
         String str = br.readLine();

         boolean flag = true;
         if (str.equals("0")) break;
         for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)){
               flag = false;
               break;
            }
         }
         
         if (flag) bw.write("yes\n");
         else bw.write("no\n");
      }

      bw.flush();
      bw.close();
      br.close();
   }
}


