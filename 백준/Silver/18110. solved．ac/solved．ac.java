import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }
      Arrays.sort(arr);

      int except = (int) Math.round(n * 0.15);
      int size = n - (except * 2);

      int result = 0;
      for(int i = except; i < size + except; i++) {
         result += arr[i];
      }

      result = (int) Math.round((double) result / size);
      bw.write(result + "\n");
      bw.flush();
      bw.close();
      br.close();
   }
}
