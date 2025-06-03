import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            Stack<Character> s = new Stack<>();
            String str = br.readLine();
            boolean flag = true;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == '('){
                    s.push(c);
                } else if(c == ')'){
                    if(s.isEmpty()){
                        flag = false;
                        break;
                    } else {
                        s.pop();
                    }
                }
            }
            if(flag && s.isEmpty())
                sb.append("YES\n");
            else
                sb.append(("NO\n"));
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
