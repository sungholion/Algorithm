import java.io.*;
import java.util.*;

public class Main {
    static int prec(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                sb.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop());
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
            } else { 
                while (!stack.isEmpty() && stack.peek() != '(' && prec(stack.peek()) >= prec(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb.toString());
    }
}
