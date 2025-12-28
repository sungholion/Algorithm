import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) stack.pop();
            else stack.push(n);
        }

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        sb.append(sum);


        System.out.print(sb.toString());
    }

}
