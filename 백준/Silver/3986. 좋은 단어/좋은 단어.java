import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스택에 남아있거나
        // 스택 사이즈가 3이 되면

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int t = 0; t < N; t++) {
            Stack<Character> stack = new Stack<>();
            boolean goodWord = true;
            String str = br.readLine();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(stack.isEmpty() || ch != stack.peek()) {
                    stack.push(ch);
                } else if(!stack.isEmpty() && ch == stack.peek()) {
                    stack.pop();
                }
            }

            if(!stack.isEmpty()){
                goodWord = false;
            }

            if(goodWord) cnt++;
        }
        System.out.print(cnt);

    }
}
