import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] numToName = new String[N + 1];
        Map<String, Integer> nameToNum = new HashMap<>(); 

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numToName[i] = name;
            nameToNum.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String query = br.readLine();

            if (Character.isDigit(query.charAt(0))) { 
                int num = Integer.parseInt(query);
                sb.append(numToName[num]).append("\n");
            } else { 
                sb.append(nameToNum.get(query)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
