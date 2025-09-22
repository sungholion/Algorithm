import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int idx=0; idx<answer.length; idx++){
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            int[] temp = new int[j-i+1];
            for(int t = 0; t<temp.length; t++){
                temp[t] = array[i-1+t];
            }
            Arrays.sort(temp);
            answer[idx] = temp[k-1];
        }
        
        return answer;
    }
}