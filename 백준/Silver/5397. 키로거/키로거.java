import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String str = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '<'){
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                } else if(c == '>'){
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                } else if(c == '-'){
                    if(!left.isEmpty()){
                        left.pop();
                    }
                } else left.push(c);
            }

            while(!left.isEmpty()){
                right.push(left.pop());
            }

            while(!right.isEmpty()){
                sb.append(right.pop());
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }
}
