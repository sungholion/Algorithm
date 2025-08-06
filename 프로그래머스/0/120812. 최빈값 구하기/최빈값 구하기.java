import java.util.*;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int big = array[array.length-1];
        int[] cnt = new int[big+1];
        
        for(int x : array)
            cnt[x]++;
        
        int maxCount = 0;
        int answer = -1;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > maxCount) {
                maxCount = cnt[i];
                answer = i;
            } else if (cnt[i] == maxCount && maxCount != 0) {
                answer = -1;
            }
        }
        
        return answer;
    }
}