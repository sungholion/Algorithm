import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int cur = 1;
        for(int i = 1; i <= n; i++) {
            int x = Integer.parseInt(br.readLine());
            while(cur <= x){
                stack.push(cur++);
                sb.append("+\n");
            }
            if(cur > x){
                if(!stack.isEmpty() && stack.peek() == x){
                    stack.pop();
                    sb.append("-\n");
                } else{
                    System.out.println("NO\n");
                    return;
                }
            }
        }

        System.out.println(sb);
    }
}
