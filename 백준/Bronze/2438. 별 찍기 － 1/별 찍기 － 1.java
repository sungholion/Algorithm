import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());

       for(int i = 0; i < n; i++){
          for(int j = 0; j <= i; j++){
             sb.append("*");
          }
          sb.append("\n");
       }

       bw.write(sb.toString());
       bw.flush();
       br.close();
       bw.close();
   }
}