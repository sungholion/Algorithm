class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String num = String.valueOf(n);
        answer = new int[num.length()];
      
        for(int i=0; i<answer.length; i++){
            answer[i] = num.charAt(num.length()-i-1) - '0';
        }
      
        return answer;
    }
}