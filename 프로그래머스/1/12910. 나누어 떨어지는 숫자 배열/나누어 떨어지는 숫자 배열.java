import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // arr과 같은 크기의 임시 배열 temp를 만들고
        // divisor로 나누어떨어지면 임시 배열에 추가하고
        // 임시 배열에서 0이 아닌 원소의 개수를 answer의 크기로 사용
        // answer 정렬
        int[] answer = {};
        int[] temp = new int[arr.length];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if((arr[i] % divisor) == 0) temp[idx++] = arr[i];
        }
        
        if(idx == 0){
            answer = new int[]{-1};
            return answer;
        }
        
        answer = new int[idx];
        for(int i=0; i<idx; i++){
            answer[i] = temp[i];
        }
        Arrays.sort(answer);
        return answer;
    }
}