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
         bw.write(q.poll() + " ");
         if(q.isEmpty()) break;
         q.offer(q.poll());
      }


      bw.flush();
      bw.close();
      br.close();
   }
}