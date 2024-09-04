import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      while(true){
         String s = br.readLine();
         Stack<Character> stack = new Stack<>();

         if(s.length() == 1 && s.charAt(0) == '.') break;

         boolean flag = true;
         for(int i = 0; i < s.length(); i++){
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

            } else if(c == '['){
               stack.push(c);
            } else if(c == ']'){
               if(!stack.isEmpty()){
                  char pop = stack.pop();
                  if(pop != '[') flag = false;
               } else {
                  flag = false;
               }
            }
         }

         if(!stack.isEmpty()){flag = false;}
         if(s.charAt(s.length()-1) != '.') flag = false;

         if(flag){
            bw.write("yes\n");
         } else {
            bw.write("no\n");
         }
      }

      bw.flush();
      bw.close();
      br.close();
   }
}