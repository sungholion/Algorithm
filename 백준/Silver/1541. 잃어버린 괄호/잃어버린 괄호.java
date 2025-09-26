import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // '-' 기준으로 식을 덩어리로 나눈다
        String[] parts = s.split("-");

        // 첫 번째 덩어리는 그냥 합산
        int result = sumOf(parts[0]);

        // 두 번째 덩어리부터는 몽땅 더해서 빼준다
        for (int i = 1; i < parts.length; i++) {
            result -= sumOf(parts[i]);
        }

        System.out.println(result);
    }

    // "10+20+30" 같은 덩어리를 받아서 더해주는 함수
    private static int sumOf(String expr) {
        int sum = 0;
        String[] nums = expr.split("\\+");
        for (String n : nums) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }
}
