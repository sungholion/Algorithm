import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();

      int n = Integer.parseInt(br.readLine());
      ArrayList<Integer> list = new ArrayList<>();

      for(int i = 0; i < n; i++){
         list.add(Integer.parseInt(br.readLine()));
      }

      Collections.sort(list); // Array.sort는 시간 초과

      for(int x : list){
         sb.append(x).append("\n");
      }

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();
   }
}


