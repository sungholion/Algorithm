import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        while (N-- > 0) {
            String line = br.readLine();
            if (line.startsWith("push")) {
                // 큐의 뒤에 넣기
                q.addLast(Integer.parseInt(line.substring(5)));
            } else if (line.equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.pollFirst()).append('\n');
            } else if (line.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if (line.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
            } else if (line.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peekFirst()).append('\n');
            } else if (line.equals("back")) {
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
