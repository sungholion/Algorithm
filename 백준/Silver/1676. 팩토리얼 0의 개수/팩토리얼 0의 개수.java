import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        for (long p = 5; p <= N; p *= 5) {
            cnt += N / p;  // N 이하에서 p의 배수 개수만큼 5가 더 생김
        }

        System.out.println(cnt);
    }
}