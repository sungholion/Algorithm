import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        Stack<Integer> stack2 = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }
        int start = 1;
        boolean ok = true;
        while(!q.isEmpty()) {
            if(q.peek() == start){
                q.poll();
                start++;
            } else if (!stack2.isEmpty() && stack2.peek() == start) {
                stack2.pop();
                start++;
            }
            else stack2.push(q.poll());
        }
        while(!stack2.isEmpty()) {
            if(stack2.peek() == start){
                stack2.pop();
                start++;
            } else {
                ok = false;
                break;
            }
        }
        if(!stack2.isEmpty() || !ok) sb.append("Sad");
        else sb.append("Nice");

        System.out.print(sb);
    }
}