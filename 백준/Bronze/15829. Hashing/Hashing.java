import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long sum = 0;

        for(int i=0; i<str.length(); i++){
            int a = Character.getNumericValue(str.charAt(i)) - Character.getNumericValue('a') + 1;
            sum += (long) (a * Math.pow(31, i) % 1234567891);
        }
        sb.append(sum);
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}