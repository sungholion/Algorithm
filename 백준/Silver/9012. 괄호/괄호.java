import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      while (n-- > 0) {
         String s = br.readLine();
         Stack<Character> stack = new Stack<>();

         boolean flag = true;
         for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
               stack.push(c);
            } else if(c == ')'){
               if(!stack.isEmpty()){
                  char pop = stack.pop();
                  if(pop != '(') flag = false;
               } else {
                  flag = false;
               }
            }
         }

         if(!stack.isEmpty()){flag = false;}
         if(flag){
            bw.write("YES\n");
         } else {
            bw.write("NO\n");
         }
      }

      bw.flush();
      bw.close();
      br.close();
   }
}