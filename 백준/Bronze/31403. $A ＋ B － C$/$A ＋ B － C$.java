import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      String a = br.readLine();
      String b = br.readLine();
      String c = br.readLine();

      bw.write(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c) + "\n");
      bw.write(Integer.parseInt(a + b) - Integer.parseInt(c) + "\n");

      bw.flush();
      br.close();
      bw.close();
   }
}