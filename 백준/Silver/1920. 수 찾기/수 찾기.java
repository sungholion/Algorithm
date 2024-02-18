import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            if(binarySearch(Integer.parseInt(st.nextToken())) >=0) System.out.println(1);
            else System.out.println(0);
        }
    }

    static int binarySearch(int x){
        int start = 0, end = arr.length-1;
        while(true){
            if(start > end) break;

            int mid = (start+end) / 2;

            if(arr[mid] > x) end = mid-1;

            else if(arr[mid] < x) start = mid + 1;

            else return mid;
        }
        return -1;
    }
}