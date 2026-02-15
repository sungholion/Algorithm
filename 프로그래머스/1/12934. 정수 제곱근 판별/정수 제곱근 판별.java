class Solution {
    public long solution(long n) {
        long answer = 0;
        double temp = (long) Math.sqrt(n);
        
        if(temp * temp == n) return (long) ((temp + 1) * (temp + 1));
        else return -1;
    }
}