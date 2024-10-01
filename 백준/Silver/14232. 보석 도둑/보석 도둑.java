import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      long n = Long.parseLong(br.readLine());

      int cnt = 0;
      for(int i = 2; i <= n; i++) {

         if(i >= 1000000){
            bw.write(n + "");
            cnt++;
            break;
         }

         while( n % i == 0){
            n /= i;
            cnt++;
            bw.write(i + " ");
         }
      
      }

      System.out.println(cnt);
      bw.flush();
      br.close();
      bw.close();

   }

}
