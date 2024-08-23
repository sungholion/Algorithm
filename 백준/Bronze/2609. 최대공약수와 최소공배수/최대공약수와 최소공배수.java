import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int greatest = gcd(a, b);
      int least = (a * b) / greatest;

      bw.write(greatest + "\n");
      bw.write(least + "\n");
      bw.flush();
      bw.close();
      br.close();
   }

   public static int gcd(int a, int b){
      while(b!=0){
         int r = a % b;

         a = b;
         b = r;
      }
      return a;
   }
}


