import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st = new StringTokenizer(br.readLine());

       double a = Integer.parseInt(st.nextToken());
       double b = Integer.parseInt(st.nextToken());
       double result = (double)a/b;

       sb.append(result);
       bw.write(sb.toString());
       bw.flush();
       br.close();
       bw.close();
   }
}