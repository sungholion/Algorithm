import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      int total = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0; i < n; i++) {
         int a = Integer.parseInt(st.nextToken());

         int cnt = 0;
         for(int j = 1; j<= a; j++){
            if (a % j == 0) {
               cnt++;
            }
         }
         if(cnt == 2){
            total++;
         }
      }

      bw.write(total+"\n");
      bw.flush();
      br.close();
      bw.close();

   }

}
