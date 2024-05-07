import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;                         //수의 개수
    static int[] operand;                 //피연산자
    static int[] operator;                //연산자
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        operand = new int[n];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            operand[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(st.nextToken());

        dfs(1, operand[0]);            // 깊이, 피연산자 배열 첫번째 원소
        
        sb.append(max).append("\n").append(min).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int num) {
        if (depth == n) {
            max = Math.max(num, max);        // 연산 결과와 최댓값,최솟값 비교 후 갱신
            min = Math.min(num, min);
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {            // 해당 연산자가 존재하면
                operator[i]--;                // 개수를 감소시키고
                switch (i) {                  // +, -, *, / 구분
                    case 0 :
                        dfs(depth+1, num + operand[depth]);    // 깊이(피연산자 계산 몇번째까지 했는지)를 1 증가시키고, 연산 진행 후 재귀
                        break;
                    case 1:
                        dfs(depth+1, num - operand[depth]);
                        break;
                    case 2:
                        dfs(depth+1, num * operand[depth]);
                        break;
                    case 3:
                        dfs(depth+1, num / operand[depth]);
                        break;
                }
                operator[i]++;                            // 매 재귀 전마다 감소시킨 연산자 개수 복구
            }
        }
    }
}