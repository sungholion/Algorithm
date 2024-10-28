class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String temp1 = a + "" + b;
        String temp2 = b + "" + a;
        
        int result1 = Integer.parseInt(temp1);
        int result2 = Integer.parseInt(temp2);
        
        answer = (result1 > result2) ? result1 : result2;
        
        return answer;
    }
}