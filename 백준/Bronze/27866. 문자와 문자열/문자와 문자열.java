import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb = new StringBuilder();

       String str = br.readLine();
       int i = Integer.parseInt(br.readLine());

       sb.append(str.charAt(i-1)).append("\n");

       bw.write(sb.toString());
       bw.flush();
       br.close();
       bw.close();
   }
}