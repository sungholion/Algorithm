import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();

      int n = Integer.parseInt(br.readLine());
      String[] arr = new String[n];

      for (int i = 0; i < n; i++){
         arr[i] = br.readLine();
      }

      Arrays.sort(arr, (a, b) -> {
         if (a.length() != b.length()) {
            return a.length() - b.length();
         } else {
            return a.compareTo(b);
         }
      });

      sb.append(arr[0]).append("\n");
      for(int i = 1; i < n; i++){   // 중복 아닌 경우만 출력
         if(!arr[i].equals(arr[i-1])){
            sb.append(arr[i]).append("\n");
         }
      }

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();
   }
}


