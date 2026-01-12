import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int pick = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int cnt = set.size();
        
        if(cnt >= pick) return pick;
        else return cnt;
    }
}