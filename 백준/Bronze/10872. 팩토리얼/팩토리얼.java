import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int sum = 1;

        while(N != 0){
            sum *= N;
            N--;
        }

        sb.append(sum);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}