import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while(!(str = br.readLine()).equals(".")){
            Stack<Character> s = new Stack<>();
            boolean isBalanced = true;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                char tmp;

                if(c == '(') s.push(c);
                else if(c == '[') s.push(c);
                else if(c == ')'){
                    if(s.isEmpty()){
                        isBalanced = false;
                        break;
                    }
                    tmp = s.pop();
                    if((tmp != '(')){
                        isBalanced = false;
                        break;
                    }
                } else if(c == ']'){
                    if(s.isEmpty()){
                        isBalanced = false;
                        break;
                    }
                    tmp = s.pop();
                    if((tmp != '[')){
                        isBalanced = false;
                        break;
                    }
                }
            }

            if(!s.isEmpty()) isBalanced = false;
            if(isBalanced) sb.append("yes\n");
            else sb.append("no\n");

        }

        System.out.println(sb);
    }
}

