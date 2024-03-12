import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        // 상점 n개
        int[] map = new int[n];
        int dong = 0;

        for(int i = 0; i<= n; i++){ // 동근이 위치까지 +1개 더 받음
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            int loc = 0;
            switch (dir){
                case 1 :    // 북
                    loc = dis;
                    break;
                case 2 :    // 남
                    loc = col + row + (col - dis);
                    break;
                case 3 :
                    loc = col + row + col + (row - dis);
                    break;
                case 4 :
                    loc = col + dis;
                    break;
            }

            if(i!=n){   // 상점인 경우
                map[i] = loc;
            }
            else{       // 동근이인 경우
                dong = loc;
            }
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            int clock = Math.abs(dong - map[i]);
            int reverse_clock = (2 * (row + col)) - clock;
            sum += Math.min(clock, reverse_clock);
        }

        System.out.println(sum);
    }
}