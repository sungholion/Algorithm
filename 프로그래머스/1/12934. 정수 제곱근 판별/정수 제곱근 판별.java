class Solution {
    public long solution(long n) {
        long answer = -1;
        long temp = (long) Math.sqrt(n);
        
        if(Math.pow(temp,2) == n ){
            answer = (long)Math.pow(temp +1,2);
        }

        
        return answer;
    }
}