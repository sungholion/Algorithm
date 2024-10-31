class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int f1 = 0;
        int f2 = 1;
        
        int f3 = -1;
        
        for(int i=2; i<=n; i++){
            f3 = f1 + f2;
            f3 %= 1234567;
            f1 = f2;
            f2 = f3;
        }
        
        answer = f3 % 1234567;
        return answer;
    }
}