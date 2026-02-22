import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        for(int x : list)
            sb.append(x).append("\n");
        System.out.println(sb);
    }
}
