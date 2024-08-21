import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st;
       String str;

       while( (str = br.readLine()) != null){
          st = new StringTokenizer(str, " ");

          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());

          sb.append(a+b).append("\n");
       }

       bw.write(sb.toString());
       bw.flush();
       br.close();
       bw.close();
   }
}