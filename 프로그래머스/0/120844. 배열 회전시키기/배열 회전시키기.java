import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int n = numbers.length;
        int[] result = new int[n];
        
       if (direction.equals("right")) {
            for (int i = 0; i < n; i++) {
                result[(i + 1) % n] = numbers[i];
            }
        } else if (direction.equals("left")) {
            for (int i = 0; i < n; i++) {
                result[i] = numbers[(i + 1) % n];
            }
        }

        return result;
    }
}