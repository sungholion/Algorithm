import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st;

      int N = Integer.parseInt(br.readLine());  // 사람 수

      int[] sizeArr = new int[6];  // 사이즈별 필요한 티셔츠 수
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<6; i++){
         sizeArr[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      int T = Integer.parseInt(st.nextToken());  // 티셔츠 묶음 수
      int P = Integer.parseInt(st.nextToken());     // 펜 묶음 수
      int cntT = 0;  // 필요 티셔츠 묶음 수

      // ---------------------------------------------------------------------------------- 입력

      for(int i=0; i<6; i++){
         cntT += sizeArr[i] / T;
         if(sizeArr[i] % T > 0){
            cntT += 1;
         }
      }

      bw.write(cntT + "\n");
      bw.write(N / P +  " " + N % P + "\n");
      bw.flush();
      bw.close();
      br.close();
   }
}