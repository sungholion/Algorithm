import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        int idx = 0;
        for(int i=0; i<prices.length-1; i++){
            int len = 0;
            for(int j=i+1; j<prices.length; j++){
                len++;
                if(prices[j] < prices[i]) break;
            }
            answer[idx++] = len;
        }
        
       
        return answer;
    }
}