import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            String name = log[0];
            String state = log[1];

            if (state.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        // HashSet → 리스트 변환 후 정렬 (역순)
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String name : list) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
