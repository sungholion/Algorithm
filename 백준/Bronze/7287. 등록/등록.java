import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      bw.write(37 + "\n");
      bw.write("tuesdaywave");
      bw.flush();
      br.close();
      bw.close();
   }
}