import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stackTmp = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String order = br.readLine();
            char orderChar = order.charAt(0);

            if(orderChar == 'L'){
                if(stack.isEmpty()) continue;
                stackTmp.push(stack.pop());
            } else if(orderChar == 'D'){
                if(stackTmp.isEmpty()) continue;
                stack.push(stackTmp.pop());
            } else if(orderChar == 'B'){
                if(stack.isEmpty()) continue;
                stack.pop();
            } else if(orderChar == 'P'){
                char x = order.charAt(2);
                stack.push(x);
            }
        }
        while (!stackTmp.isEmpty()){
            stack.push(stackTmp.pop());
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().toString());


    }
}