class Solution {
    public long solution(int a, int b) {
        long answer = 0;
    
        int s = 0;
        int e = 0;
        if(a > b){
            s = b;
            e = a;
        } else if(a < b){
            s = a;
            e = b;
        } else if(a == b){
            answer = a;
            return answer;
        }
        
        for(int i =s; i<=e; i++){
            answer += i;
        }
        
        return answer;
    }
}