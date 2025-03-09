import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        
        int cnt = 0;
        for(int i = 0; i<commands.length; i++){
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int target = commands[i][2];
            
            int len = end - start;
            int[] newArr = new int[len];
            int idx = 0;
            
            for(int k = 0; k < len; k++){
                newArr[k] = array[start + k];  // array에서 올바른 값을 복사
            }
            Arrays.sort(newArr);
            
            answer[cnt++] = newArr[target-1];
            
            
        }
        
        return answer;
    }
}