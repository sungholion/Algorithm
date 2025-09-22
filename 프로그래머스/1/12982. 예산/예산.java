import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int cnt = 0;
        for(int i=0; i<d.length; i++){
            if(budget - d[i] >= 0){
                cnt++;
                budget -= d[i];
            } else break;
        }   
        
        return cnt;
    }
}