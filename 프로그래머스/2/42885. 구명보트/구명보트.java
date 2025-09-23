import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int l = people.length;
        int answer = 0;
        
        int left = 0, right = l-1;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++; 
            } 
            right--;
            answer++;
            
        }
      
        
        
        return answer;
    }
}