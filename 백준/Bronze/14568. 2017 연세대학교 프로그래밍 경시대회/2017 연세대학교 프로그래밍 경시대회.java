import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int N = Integer.parseInt(br.readLine());

      int answer = 0;
      for(int i = 2; i < N; i+=2) {
         for(int j = 1; j < N; j++) {
            for(int k = j+2; k < N; k++) {
                 if(i + j + k == N) {
                    answer++;
                 }
            }
         }
      }


      bw.write(answer + "\n");
      br.close();
      bw.flush();
      bw.close();
   }
}
