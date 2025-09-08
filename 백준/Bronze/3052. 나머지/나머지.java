import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        int[] arr = new int[42];

        for(int i=0; i<10; i++){
            int tmp = Integer.parseInt(br.readLine());
            arr[tmp%42]++;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                cnt++;
            }
        }

        sb.append(cnt);

        System.out.println(sb.toString());
    }
}