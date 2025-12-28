import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
        공백 4 3 2 1 0 1 2 3 4
        1 3 5 7 9 7 5 3 1
        줄바꿈
         */
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){ // 줄 바꿈 0 1 2 3 4
            for(int j = N; j > i; j--){ // 공백 4 3 2 1
                sb.append(" ");
            }
            for(int k = 0; k < 2 * i - 1; k++){ // 별
                sb.append("*");
            }
            sb.append("\n");
        }

        for(int i = N - 1; i >= 1; i--){ // 줄 바꿈 0 1 2 3 4
            for(int j = N; j > i; j--){ // 공백 4 3 2 1
                sb.append(" ");
            }
            for(int k = 0; k < 2 * i - 1; k++){ // 별
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }
}