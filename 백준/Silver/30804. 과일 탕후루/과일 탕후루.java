import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int left = 0;
        for(int right = 0; right < N; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while(map.size() > 2){
                int leftFruit = arr[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if(map.get(leftFruit) == 0){map.remove(leftFruit);}
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
