import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxValue = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i=0; i<9; i++){
            int n = Integer.parseInt(br.readLine());
            if(n > maxValue){
                maxValue = n;
                maxIdx = i + 1;
            }
        }

        bw.write(maxValue+"\n");
        bw.write(maxIdx+"\n");
        bw.flush();
    }
}