import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str;
        while(!(str = br.readLine()).equals(".")){
            Stack<Character> s = new Stack<>();
            boolean tf = true;

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == '(')
                    s.push(c);
                else if(c == ')'){
                    if(s.isEmpty() || s.peek() != '('){
                        tf = false;
                        break;
                    }
                    else
                        s.pop();
                }
                else if(c == '[')
                    s.push(c);
                else if(c == ']'){
                    if(s.isEmpty() || s.peek() != '['){
                        tf = false;
                        break;
                    }
                    else
                        s.pop();
                } else  // 그냥 알파벳일때
                    continue;
            }

            if(tf && s.isEmpty())
                sb.append("yes\n");
            else
                sb.append("no\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}