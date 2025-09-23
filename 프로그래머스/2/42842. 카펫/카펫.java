class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int t = brown + yellow;
        
        for(int i=1; i<=t; i++){
            if(t % i == 0){
                int a = i;
                int b = t / i;
                
                if((a-2) * (b-2) == yellow){
                    if(a >= b){
                        answer[0] = a;
                        answer[1] = b;
                    }

                }
            }
        }
        
        return answer;
    }
}