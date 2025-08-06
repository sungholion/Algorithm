class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int cnt = num2 - num1 + 1;
        int[] answer = new int[cnt];
        
        for(int i=0; i<cnt; i++){
            answer[i] = numbers[num1 + i];
        }
        return answer;
    }
}