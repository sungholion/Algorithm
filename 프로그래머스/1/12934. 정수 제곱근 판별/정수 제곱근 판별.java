class Solution {
    public long solution(long n) {
        // x = 제곱근(sqrt)로 구한 값을 int로 바꾸고
        // n을 x로 나눴을 때 x와 같은지 비교
        long answer = 0;
        
        long x = (long)Math.sqrt(n);
        if((x * x) == n) answer = (long)Math.pow((x+1), 2);
        else answer = -1;
        
        return answer;
    }
}