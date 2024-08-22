import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int[] cnt = new int[26];
      for(int i = 0; i < 26; i++){
         cnt[i] = -1;
      }

      String str = br.readLine();

      for(int i = 0; i < str.length(); i++){
         if(cnt[str.charAt(i) - 'a'] == -1){
            cnt[str.charAt(i) - 'a'] = i;
         }
      }

      for(int i = 0; i < 26; i++){
         bw.write(cnt[i] + " ");
      }


      bw.flush();
      br.close();
      bw.close();
   }
}