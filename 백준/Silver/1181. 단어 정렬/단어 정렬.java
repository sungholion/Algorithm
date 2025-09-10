import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        while(N-- > 0) set.add(br.readLine());

        List<String> words = new ArrayList<>(set);

        words.sort((a,b) -> {
            if(a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });

        for(String word : words) {
            sb.append(word).append("\n");
        }
        System.out.println(sb.toString());
    }
}