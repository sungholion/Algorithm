import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] card = new int[21];
        for(int i = 1;  i <= 20; i++) card[i] = i;

        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while (a < b) {
                int temp = card[a];
                card[a] = card[b];
                card[b] = temp;
                a++;
                b--;
            }
        }

        for(int i = 1; i <= 20; i++) sb.append(card[i]).append(" ");
        System.out.print(sb);
    }
}