import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        boolean[] arr = new boolean[31];

        for(int i=0; i<28; i++){
            int n = Integer.parseInt(br.readLine());
            arr[n] = true;
        }

        for(int i = 1; i < 31; i++){
            if(!arr[i])
                sb.append(i).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}