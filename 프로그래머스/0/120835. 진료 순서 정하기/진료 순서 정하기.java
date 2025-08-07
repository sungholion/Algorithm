import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        int[] temp = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(temp);
        
        for(int i=0; i<temp.length / 2; i++){
            int tmp = temp[i];
            temp[i] = temp[temp.length - i - 1];
            temp[temp.length - i - 1] = tmp;
        }
        
        int cnt = 0;
        for(int i=0; i<emergency.length; i++){
            for(int j=0; j<temp.length; j++){
                if(emergency[i] == temp[j]){
                    answer[cnt++] = j + 1;
                }
            }
        }
        
        return answer;
        
        /*
        
        3 76 24
        76 24 3
        
        */
        
    }
}