import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-- > 0) set.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(M --> 0){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1).append("\n");
            } else{
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}