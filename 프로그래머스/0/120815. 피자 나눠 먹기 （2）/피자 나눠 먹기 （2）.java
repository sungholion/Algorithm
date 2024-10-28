class Solution {
    public int solution(int n) {
        int answer = 0;

        int pizza = 6;
        while(true){
            if(pizza % n == 0){
                answer++;
                break;
            }
            
            pizza += 6;
            answer++;
            
        }
        
        return answer;
    }
}