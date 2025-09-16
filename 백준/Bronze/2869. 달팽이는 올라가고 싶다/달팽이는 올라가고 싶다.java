import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()); 
        long B = Long.parseLong(st.nextToken()); 
        long V = Long.parseLong(st.nextToken()); 

        long days = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) days++; 
        
        sb.append(days);
        System.out.println(sb);
    }
}
