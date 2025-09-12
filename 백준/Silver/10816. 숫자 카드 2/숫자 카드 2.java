import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(map.get(temp) == null) sb.append(0).append(" ");
            else sb.append(map.get(temp)).append(" ");

        }
        System.out.println(sb);
    }
}