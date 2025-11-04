import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[42];
        int res = 0;
        for(int i=0; i<10; i++){
            int n = Integer.parseInt(br.readLine());
            arr[n%42]++;
        }

        for(int x : arr)
            if(x != 0) res++;

        System.out.println(res);
    }
}
