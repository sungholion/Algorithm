import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arr = new int[8];
      String result = "";

      for(int i = 0; i < 8; i++){
         arr[i] = Integer.parseInt(st.nextToken());
      }

      for(int i=0; i <arr.length - 1; i++){
         if(arr[i+1] == arr[i] + 1){
            result = "ascending";
         } else if(arr[i+1] == arr[i] - 1){
            result = "descending";
         } else {
            result = "mixed";
            break;
         }
      }

      bw.write(result);
      bw.flush();
      br.close();
      bw.close();
   }
}