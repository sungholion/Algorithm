import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '('){
                    stack.push(c);
                } else if(c == ')'){
                    if(stack.isEmpty() || !stack.peek().equals('(')){
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(flag && stack.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.print(sb.toString());
    }

}
