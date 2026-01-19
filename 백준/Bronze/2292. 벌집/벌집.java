import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int layer = 1;
        int bee = 1;
        while(N > bee){
            bee += layer * 6;
            layer++;
        }
        System.out.print(layer);
    }
}
