import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // 이분 탐색을 위해 정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int key = Integer.parseInt(st.nextToken());
            int count = upperBound(key) - lowerBound(key);
            sb.append(count).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    public static int lowerBound(int key) {
        int low = 0;
        int high = arr.length;

        while(low < high){
            int mid = (low + high) / 2;
            if(arr[mid] < key){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(int key) {
        int low = 0;
        int high = arr.length;

        while(low < high){
            int mid = (low + high) / 2;
            if(arr[mid] <= key){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
