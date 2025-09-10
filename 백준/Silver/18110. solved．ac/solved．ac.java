import java.io.*;
import java.util.*;

class Coord{
    int x;
    int y;

    Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int cut = (int)Math.round(N * 0.15); // 앞뒤 절삭 개수
        int sum = 0;
        for(int i = cut; i < N - cut; i++) {
            sum += arr[i];
        }

        int avg = (int)Math.round((double)sum / (N - 2*cut));
        sb.append(avg).append("\n");

        System.out.println(sb.toString());
    }
}