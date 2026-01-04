import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T  = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            ArrayDeque<Integer> q = new ArrayDeque<>();
            String temp = br.readLine();
            temp = temp.substring(1, temp.length() - 1);
            if(!temp.isEmpty()){
                StringTokenizer st = new StringTokenizer(temp, ",");
                for(int i = 0; i < n; i++){
                    q.offer(Integer.parseInt(st.nextToken()));
                }
            }

            int rCnt = 0;
            boolean isPossible = true;
            for(int i = 0; i < p.length(); i++){
                char c = p.charAt(i);
                if(c == 'R') rCnt++;
                if(c == 'D'){
                    if(q.isEmpty()){
                        isPossible = false;
                        break;
                    }
                    if(rCnt % 2 == 1){
                        q.pollLast();
                    } else {
                        q.pollFirst();
                    }
                }
            }
            if(isPossible){
                sb.append("[");
                if(rCnt % 2 == 1){
                    while(!q.isEmpty()){
                        sb.append(q.pollLast());
                        if(!q.isEmpty()) sb.append(",");
                    }
                }
                else {
                    while(!q.isEmpty()){
                        sb.append(q.poll());
                        if(!q.isEmpty()) sb.append(",");
                    }
                }
                sb.append("]\n");
            }
            else {
                sb.append("error\n");
            }
        }
        System.out.println(sb);
    }
}
