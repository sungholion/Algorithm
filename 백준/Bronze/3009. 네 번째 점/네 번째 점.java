import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        if(x1 == x2) sb.append(x3).append(" ");
        else if(x2 == x3) sb.append(x1).append(" ");
        else sb.append(x2).append(" ");

        if(y1 == y2) sb.append(y3).append(" ");
        else if(y2 == y3) sb.append(y1).append(" ");
        else sb.append(y2).append(" ");


        System.out.print(sb);
    }
}