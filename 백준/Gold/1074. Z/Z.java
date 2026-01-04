import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = 1 << N;
        int answer = 0;

        while(size >= 1){
            size /= 2;
            int quad = size * size;

            if (r < size && c < size) {
            } else if (r < size && c >= size) {
                answer += quad;
                c -= size;
            } else if (r >= size && c < size) {
                answer += quad * 2;
                r -= size;
            } else {
                answer += quad * 3;
                r -= size;
                c -= size;
            }
        }
        System.out.print(answer);
    }
}
