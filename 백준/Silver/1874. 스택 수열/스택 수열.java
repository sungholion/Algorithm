import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int start = 0;
        Stack<Integer> s = new Stack<>();
        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(num > start){
                for(int i = start + 1; i <= num; i++){
                    s.push(i);
                    sb.append('+').append("\n");
                }
                start = num;
            } else if(s.peek() != num){
                System.out.println("NO");
                return;
            }

            s.pop();
            sb.append('-').append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}