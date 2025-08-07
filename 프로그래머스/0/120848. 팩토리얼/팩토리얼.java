class Solution {
   public int solution(int n) {
        int answer = 1;
        int temp = 1;

        while (temp <= n) {
            answer++;
            temp *= answer;
        }
        return answer - 1; 
    }
}