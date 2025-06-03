import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            } else if(com.equals("pop")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            } else if(com.equals("size")){
                sb.append(q.size()).append("\n");
            } else if(com.equals("empty")){
                if(q.isEmpty()){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if(com.equals("front")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
            } else if(com.equals("back")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(q.peekLast()).append("\n");
                }
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
