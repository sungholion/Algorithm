import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> factors = new ArrayList<>();
        
        for (int i = 2; i * i <= n; i++) {
            boolean added = false;
            while (n % i == 0) {
                if (!added) { 
                    factors.add(i);
                    added = true;
                }
                n /= i;
            }
        }
        
        if (n > 1) {
            factors.add(n);
        }
        
        int[] answer = new int[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            answer[i] = factors.get(i);
        }
        
        return answer;
    }
}
