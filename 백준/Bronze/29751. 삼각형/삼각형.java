import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
 
        double result = 0;
 
        result = (W*H)/2.0;
        System.out.printf("%.1f", result);
    }
}