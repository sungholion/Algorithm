import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_value = Integer.parseInt(br.readLine());
        int max_idx = 1;
        for(int i = 2; i <= 9; i++){
            int n = Integer.parseInt(br.readLine());
            if(n > max_value){
                max_value = n;
                max_idx = i;
            }
        }

        bw.write(max_value + "\n" + max_idx + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}