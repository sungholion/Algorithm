import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
            } else if(command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            } else if(command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if(set.contains(x)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if(command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if(set.contains(x)) set.remove(x);
                else set.add(x);
            } else if(command.equals("all")) {
                set = new HashSet<>();
                for(int t = 1; t <= 20; t++)
                    set.add(t);
            } else if(command.equals("empty")) {
                set.clear();
            }
        }
        System.out.print(sb.toString());
    }
}
