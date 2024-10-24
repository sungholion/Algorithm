class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        answer = new int[2];
        
        int up = (numer1 * denom2) + (numer2 * denom1);
        int down = (denom1 * denom2);
        
        int max = -1;
        for(int i = 1; i<= up && i <= down; i++){
            if(up % i == 0 && down % i == 0){
                max = i;
            }
        }
        
        up /= max;
        down /= max;
        
        answer[0] = up;
        answer[1] = down;
        
        return answer;
    }
}