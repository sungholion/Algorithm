import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        int aIdx = 0;
        int bIdx = 0;

        List<Integer> result = new ArrayList<>();

        while (true) {
            int maxVal = -1;
            int maxAIdx = -1;
            int maxBIdx = -1;

            for (int i = aIdx; i < N; i++) {
                for (int j = bIdx; j < M; j++) {
                    if (A[i] == B[j]) {
                        if (A[i] > maxVal) {
                            maxVal = A[i];
                            maxAIdx = i;
                            maxBIdx = j;
                        }
                    }
                }
            }

            if (maxVal == -1) break;

            result.add(maxVal);

            aIdx = maxAIdx + 1;
            bIdx = maxBIdx + 1;
        }

        System.out.println(result.size());
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
