import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;
      int t = Integer.parseInt(br.readLine());


      for(int i = 0; i < t; i++){
         st = new StringTokenizer(br.readLine());
         int r = Integer.parseInt(st.nextToken());
         String s = st.nextToken();
         StringBuilder result = new StringBuilder();

         for(int j = 0; j < s.length(); j++){
            for(int k = 0; k < r; k++)
               result.append(s.charAt(j));
         }
         bw.write(result + "\n");
      }

      bw.flush();
      br.close();
      bw.close();
   }
}