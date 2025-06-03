import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        while(K-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                s.pop();
            } else{
                s.push(num);
            }
        }

        int sum = 0;
        while(!s.isEmpty())
            sum += s.pop();

        sb.append(sum).append(("\n"));
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
