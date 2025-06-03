import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if(N == 4 || N == 7)
            sb.append(-1);
        else if(N % 5 == 0)
            sb.append(N / 5);
        else if( (N % 5 == 1) || (N % 5 == 3))
            sb.append(((N / 5) + 1));
        else if( (N % 5 == 2) || (N % 5 == 4))
            sb.append(((N / 5) + 2));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}

/*
    3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
    1-1 1 2-1 2 3 2  3  4  3  4  3  4  5  4  5  4  5  6  5  6  5  6  7  6  7  6     <- 봉지개수
        1         2              3              4              5              6     <- 5의 몫
    3 4 0 1 2 3 4 0  1  2  3  4  0  1  2  3  4  0  1  2  3  4  0  1  2  3  4  0     <- 나머지

    1. 4와 7은 불가능
    2. (5의 배수 + 1번째)는 몫 + 나머지
    3. (5의 배수 + 3번째)는 (5의 배수 + 1번째)와 같음
    4. (5의 배수 + 2번째)는 몫 + 나머지(2로 고정)
    5. (5의 배수 + 4번째)는 (5의 배수 + 2번째)와 같음
 */