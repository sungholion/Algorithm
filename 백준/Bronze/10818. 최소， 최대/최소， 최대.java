import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arr = new int[n];

      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      for(int i = 0; i < n; i++){
         arr[i] = Integer.parseInt(st.nextToken());
         if(arr[i] > max){
            max = arr[i];
         }

         if(arr[i] < min){
            min = arr[i];
         }
      }

      bw.write(min + " " + max + "\n");
      bw.flush();
      br.close();
      bw.close();
   }
}