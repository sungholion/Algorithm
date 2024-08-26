import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int t = Integer.parseInt(br.readLine());

      for(int i = 0; i < t; i++){
         int [][] apt = new int[15][15];

         for(int j=0; j<15; j++){   // 0층 값 설정 및 모든 층 1호 1로 초기화
            apt[j][1] = 1;
            apt[0][j] = j;
         }

         int k = Integer.parseInt(br.readLine());     //층
         int n = Integer.parseInt(br.readLine());     //호

         for(int l=1; l < 15; l++){
            for(int m=2; m < 15; m++){
               apt[l][m] = apt[l][m-1] + apt[l-1][m];
            }
         }

         bw.write(apt[k][n] + "\n");

      }

      bw.flush();
      bw.close();
      br.close();
   }
}


