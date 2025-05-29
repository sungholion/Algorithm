import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int total = A * B * C;

        int[] numbers = new int[10];
        String str = String.valueOf(total);

        for(int i = 0; i <= 9; i++){
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c - '0' == i){
                    numbers[i]++;
                }
            }
        }

        for(int x : numbers)
            bw.write(x + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
