import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] temp = new int[my_string.length()];
        
        int cnt = 0;
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(Character.isDigit(c))
                temp[cnt++] = c - '0';
        }
        
        int[] answer = new int[cnt];
        for(int i=0; i<cnt; i++)
            answer[i] = temp[i];
        
        Arrays.sort(answer);
        
        return answer;
    }
}