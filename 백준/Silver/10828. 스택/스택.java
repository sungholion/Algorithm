import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> s = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push")){
                int n = Integer.parseInt(st.nextToken());
                s.push(n);
            } else if(str.equals("pop")){
                if(s.isEmpty()) sb.append("-1").append("\n");
                else sb.append(s.pop()).append("\n");
            } else if(str.equals("size")){
                sb.append(s.size()).append("\n");
            } else if(str.equals("empty")){
                if(s.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else if(str.equals("top")){
                if(s.isEmpty()) sb.append("-1").append("\n");
                else sb.append(s.peek()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}