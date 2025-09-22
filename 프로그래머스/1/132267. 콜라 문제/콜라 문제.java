class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            int plus = (n / a) * b;
            answer += plus;
            n = plus + (n % a);
            
        }
        return answer;
    }
}