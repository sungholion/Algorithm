import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb = new StringBuilder();

       int x = (int)br.readLine().charAt(0);

       sb.append(x).append("\n");

       bw.write(sb.toString());
       bw.flush();
       br.close();
       bw.close();
   }
}