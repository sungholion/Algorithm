class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        answer = new long[n];
        
        long add = x;
        for(int i=0; i<n; i++){
            answer[i] = add;
            add += x;
        }
        
        return answer;
    }
}