import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);  // 이분 탐색하려면 정렬 되어있어야 함.

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int key = -1;
        for(int i=0; i<M; i++){
            key = Integer.parseInt(st.nextToken());
            sb.append(binarysearch(key)).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int binarysearch(int key){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(key < arr[mid]){
                high = mid - 1;
            }
            else if(key > arr[mid]){
                low = mid + 1;
            }
            else{
                return 1;
            }
        }
        return 0;
    }
}
