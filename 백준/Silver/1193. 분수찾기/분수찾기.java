import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine()); // 찾고 싶은 분수의 번호

        int line = 1;   // 현재 줄
        int count = 0;  // 분수 개수 합

        // 몇 번째 줄에 속하는지 찾기
        while (count + line < X) {
            count += line;
            line++;
        }

        // line번째 줄의 몇 번째 분수인지
        int order = X - count;

        int numer;   // 분자
        int denom; // 분모

        // line이 짝수일 때 오른쪽 위 방향
        if (line % 2 == 0) {
            numer = order;
            denom = line - order + 1;
        }
        // line이 홀수일 때 왼쪽 아래 방향
        else {
            numer = line - order + 1;
            denom = order;
        }

        System.out.println(numer + "/" + denom);
    }
}