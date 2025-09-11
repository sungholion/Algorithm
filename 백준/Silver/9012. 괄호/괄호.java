import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T--> 0){
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            boolean isBalanced = true;

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == '(') s.push(c);
                else if(c == ')'){
                    if(s.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    char temp = s.pop();
                    if(temp != '('){
                        isBalanced = false;
                        break;
                    }
                }
            }

            if(!s.isEmpty()) isBalanced = false;
            if(isBalanced) sb.append("YES\n");
            else sb.append("NO\n");


        }
        System.out.println(sb);
    }
}

