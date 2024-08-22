import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int[] numCnt = new int[10];

      int multiply = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
      String str = String.valueOf(multiply);

      for(int i = 0; i < str.length(); i++){
         numCnt[str.charAt(i) - '0']++;
      }

      for(int n : numCnt){
         bw.write(n + "\n");
      }

      bw.flush();
      br.close();
      bw.close();
   }
}