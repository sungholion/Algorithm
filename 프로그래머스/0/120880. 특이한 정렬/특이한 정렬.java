import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] arr = Arrays.stream(numlist).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> {
            int da = Math.abs(a - n);
            int db = Math.abs(b - n);
            if (da != db) return Integer.compare(da, db); // 거리 작은 순
            return Integer.compare(b, a);                 // 값 큰 순
        });

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }
}