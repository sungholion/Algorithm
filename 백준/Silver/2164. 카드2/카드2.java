import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      Queue<Integer> q= new LinkedList<>();

      for(int i = 1; i <= n; i++){
         q.offer(i);
      }

      while(true){
         if(q.size() != 1){
            q.poll();
            q.offer(q.poll());
         } else {
            bw.write(q.poll() + "\n");
            break;
         }
      }

      bw.flush();
      bw.close();
      br.close();
   }
}