import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }
        Collections.sort(list, (a, b) -> {
            if(a[1] == b[1]){return a[0]-b[0];}
            return a[1] - b[1];
        });

        int cnt = 0;
        int cur = 0;
        for(int[] arr : list){
            if(arr[0] >= cur){
                cnt++;
                cur = arr[1];
            }
        }
        System.out.println(cnt);
    }
}