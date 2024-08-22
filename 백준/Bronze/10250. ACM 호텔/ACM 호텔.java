import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();

      int t = Integer.parseInt(br.readLine());

      for(int i = 0; i < t; i++){
         st = new StringTokenizer(br.readLine());
         int h = Integer.parseInt(st.nextToken());
         int w = Integer.parseInt(st.nextToken());
         int n = Integer.parseInt(st.nextToken());

         int x = n % h;
         int y = 1 + n / h;
         if(x == 0){
            x = h;
            y -= 1;
         }

         boolean needZero = y < 10;

         if(needZero){
            sb.append(x).append(0).append(y).append("\n");
         }
         else{
            sb.append(x).append(y).append("\n");
         }
      }


      bw.write(sb.toString());
      bw.flush();
      br.close();
      bw.close();
   }
}