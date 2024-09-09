import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());

      if (n == 4 || n == 7) {
         bw.write(-1 + "\n");
      }
      else if (n % 5 == 0) {
         bw.write(n / 5 + "\n");
      }
      else if (n % 5 == 1 || n % 5 == 3) {
         bw.write((n / 5) + 1 + "\n");
      }
      else if (n % 5 == 2 || n % 5 == 4) {
         bw.write((n / 5) + 2 + "\n");
      }


      bw.flush();
      bw.close();
      br.close();
   }
}
