import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int L = Integer.parseInt(br.readLine());
      String str = br.readLine();

      //result = result.add(BigInteger.valueOf(S.charAt(i) - 96).multiply(BigInteger.valueOf(31).pow(i)));
      //System.out.println(result.remainder(BigInteger.valueOf(1234567891)));
      BigInteger result = new BigInteger("0");
      for(int i = 0; i < str.length(); i++){
         char ch = str.charAt(i);
         result = result.add(BigInteger.valueOf(ch - 96).multiply(BigInteger.valueOf(31).pow(i)));
      }

      bw.write(result.remainder(BigInteger.valueOf(1234567891)) + "");
      bw.flush();
      bw.close();
      br.close();
   }
}