import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[42];
        int cnt = 0;

        for(int i = 0; i < 10; i++){
            int n = Integer.parseInt(br.readLine());
            arr[n%42]++;
        }

        for(int x : arr){
            if(x != 0)
                cnt++;
        }

        bw.write(cnt + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}