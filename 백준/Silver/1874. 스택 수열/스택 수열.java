import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        int start = 1;
        boolean possible = true;
        while(n --> 0){
            int x = Integer.parseInt(br.readLine());
            while(start <= x){
                s.push(start++);
                sb.append("+\n");
            }

            if(s.empty() || s.peek() != x){
                possible = false;
                break;
            }

            s.pop();
            sb.append("-\n");
        }

        if(possible)
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}

