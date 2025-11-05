import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int layer = 1;
        int bee = 1;
        while(N > bee){
            bee += 6 * layer;
            layer++;
        }
        System.out.println(layer);

    }
}
