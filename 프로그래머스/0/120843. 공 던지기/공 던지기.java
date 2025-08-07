class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        int n = numbers.length;
        for(int i=0; i<=n; i = (i+2) % n){
            if(k == 1){
                answer = numbers[i];
                break;
            }
            k--;
            
        }
        
        return answer;
    }
}