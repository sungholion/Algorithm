import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int h = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      if(m - 45 >= 0){
         m -= 45;
      }
      else if(m - 45 < 0){
         h -= 1;
         m = m + 60 - 45;
      }

      if(h < 0){
         h+= 24;
      }

      bw.write(h + " " + m + "\n");
      bw.flush();
      br.close();
      bw.close();
   }
}