import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
        9 7 5 3 1 3 5 7 9
        0 1 2 3 4 3 2 1 0
        줄바꿈

         */

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                sb.append(" ");
            }
            for(int j = 0; j < (2 * N - 1) - (2 * i); j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < N - 1 - i; j++){
                sb.append(" ");
            }

            for(int j = (2 * i) + 1; j > 0; j--){
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.print(sb);

    }
}