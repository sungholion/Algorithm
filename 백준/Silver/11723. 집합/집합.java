import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;

            if(command.equals("all")){
                set.clear();
                for(int i = 1; i <= 20; i++)
                    set.add(i);
            } else if(command.equals("empty")){
                set.clear();
            } else if(command.equals("add")){
                x = Integer.parseInt(st.nextToken());
                set.add(x);
            } else if(command.equals("remove")){
                x = Integer.parseInt(st.nextToken());
                set.remove(x);
            } else if(command.equals("check")){
                x = Integer.parseInt(st.nextToken());
                sb.append(set.contains(x) ? 1 : 0).append("\n");
            } else if(command.equals("toggle")){
                x = Integer.parseInt(st.nextToken());
                if(set.contains(x)){
                    set.remove(x);
                } else {
                    set.add(x);
                }
            }


        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}