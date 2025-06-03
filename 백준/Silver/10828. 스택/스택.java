import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> s = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                s.push(num);
            } else if(com.equals("pop")){
                if(s.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(s.pop()).append("\n");
                }
            } else if(com.equals("size")){
                sb.append(s.size()).append("\n");
            } else if(com.equals("empty")){
                if(s.isEmpty()){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if(com.equals("top")){
                if(s.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(s.peek()).append("\n");
                }
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
