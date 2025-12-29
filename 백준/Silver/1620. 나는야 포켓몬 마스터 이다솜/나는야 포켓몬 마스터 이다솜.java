import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] getNum = new String[N+1];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            getNum[i] = str;
            map.put(str, i);
        }
        for(int i = 1; i <= M; i++) {
            String str = br.readLine();
            if(Character.isDigit(str.charAt(0))){
                sb.append(getNum[Integer.parseInt(str)]).append("\n");
            } else {
                sb.append(map.get(str)).append("\n");

            }
        }

        System.out.print(sb);
    }
}