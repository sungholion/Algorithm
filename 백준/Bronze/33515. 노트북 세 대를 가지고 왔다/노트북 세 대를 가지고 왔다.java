import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T1 = Integer.parseInt(st.nextToken());
        int T2 = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(T1, T2));
    }
}