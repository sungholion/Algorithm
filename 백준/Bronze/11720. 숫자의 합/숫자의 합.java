import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      br.readLine();
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int result = 0;
      for(byte v : br.readLine().getBytes()) {
         result += (v - '0');	// 또는 (a-48)
      }

      bw.write(String.valueOf(result));
      bw.flush();
      br.close();
      bw.close();
   }
}