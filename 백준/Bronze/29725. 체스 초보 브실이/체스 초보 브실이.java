import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] score = new int[128];
        score['P'] = 1; score['p'] = -1;
        score['N'] = 3; score['n'] = -3;
        score['B'] = 3; score['b'] = -3;
        score['R'] = 5; score['r'] = -5;
        score['Q'] = 9; score['q'] = -9;

        int result = 0;

        // 8줄 입력 읽기
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                char c = line.charAt(j);
                result += score[c]; 
            }
        }

        System.out.println(result);
    }
}