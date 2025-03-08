class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = {};
        answer = new int[num2 - num1 + 1];
        int idx = 0;
        
        for(int i=0; i+num1 <= num2; i++){
            answer[i] = numbers[i+num1];
        }
        
        
        return answer;
    }
}