import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // n!, k!, (n-k)! 계산
        int factN = 1;
        for (int i = 1; i <= n; i++) factN *= i;

        int factK = 1;
        for (int i = 1; i <= k; i++) factK *= i;

        int factNK = 1;
        for (int i = 1; i <= n - k; i++) factNK *= i;

        // 공식 적용: n! / (k! * (n-k)!)
        int result = factN / (factK * factNK);

        System.out.println(result);
    }
}
