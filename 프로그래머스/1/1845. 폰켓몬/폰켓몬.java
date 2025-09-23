import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        
        if(set.size() >= n) return n;
        else return set.size();

    }
}