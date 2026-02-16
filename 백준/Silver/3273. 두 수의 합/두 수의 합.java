import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum == x){
                answer++;
                left++;
                right--;
            } else if(sum < x){
                left++;
            } else if(sum > x){
                right--;
            }
        }

        System.out.println(answer);


    }
}
