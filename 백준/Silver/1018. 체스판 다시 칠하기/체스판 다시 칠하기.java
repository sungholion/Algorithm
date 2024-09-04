import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      String[] arr = new String[n];

      for (int i = 0; i < n; i++) {
         arr[i] = br.readLine();
      }

      int res = Integer.MAX_VALUE;
      for(int i = 0; i <= n - 8; i++){
         for(int j = 0; j <= m - 8; j++){
            int curRes = getRes(i, j, arr);
            if(curRes < res){
               res = curRes;
            }
         }
      }

      bw.write(String.valueOf(res));
      bw.flush();
      bw.close();
      br.close();
   }

   public static int getRes(int startRow, int startCol, String[] arr){
      String[] correctArr = {"BWBWBWBW", "WBWBWBWB"};
      int black = 0;

      for(int i=0; i<8; i++){
         int row = startRow + i;
         for(int j=0; j<8; j++){
            int col = startCol + j;
            if(arr[row].charAt(col) != correctArr[row % 2].charAt(j)) black++;
         }
      }

      return Math.min(black, 64-black);
   }
}