import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st = new StringTokenizer(br.readLine());

       int a = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());

       if(a > b){
          sb.append(">");
       } else if(a < b){
          sb.append("<");
       } else {
          sb.append("==");
       }

       bw.write(sb.toString());
       bw.flush();
       br.close();
       bw.close();
   }
}