import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (N >= 0) {
            if (N % 5 == 0) {            // 5로 깔끔히 나눠지면 마무리
                cnt += N / 5;
                System.out.println(cnt);
                return;
            }
            N -= 3;                      // 5로 안 나눠지면 3 한 봉지 사용
            cnt++;
        }
        System.out.println(-1);          // 끝까지 못 맞추면 불가능
    }
}