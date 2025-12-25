import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        sb.append(1 - k).append(" ");
        int q = Integer.parseInt(st.nextToken());
        sb.append(1- q).append(" ");
        int l = Integer.parseInt(st.nextToken());
        sb.append(2- l).append(" ");
        int b = Integer.parseInt(st.nextToken());
        sb.append(2- b).append(" ");
        int n = Integer.parseInt(st.nextToken());
        sb.append(2- n).append(" ");
        int p = Integer.parseInt(st.nextToken());
        sb.append(8- p).append(" ");

        System.out.println(sb.toString());
    }
}