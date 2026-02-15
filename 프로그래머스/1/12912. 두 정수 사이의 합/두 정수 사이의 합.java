class Solution {
    public long solution(int a, int b) {
        if(a == b) return a;
        
        long answer = 0;
        int start = 0;
        int end = 0;
        if(a < b){
            start = a;
            end = b;
        } else {
            start = b;
            end = a;
        }
        
        for(int i = start; i <= end; i++) answer += i;
        
        return answer;
    }
}