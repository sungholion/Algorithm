import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      bw.write(Integer.toString(Pas(n,k)));
      bw.flush();
      bw.close();
      br.close();
   }

   static int Pas(int n, int k) {
      if(n == k || k == 0) {
         return 1;
      }

      return Pas(n - 1, k - 1) + Pas(n - 1, k);
   }
}