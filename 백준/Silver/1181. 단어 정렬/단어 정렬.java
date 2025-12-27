import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);

        list.sort((a, b) -> {
           if(a.length() == b.length()) return a.compareTo(b);
           return a.length() - b.length();
        });

        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
