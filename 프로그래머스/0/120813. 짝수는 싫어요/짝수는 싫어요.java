class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int index = (n % 2 == 0) ? (n/2) : (n/2) + 1;
        
        answer = new int[index];
        
        int add = 1;
        for(int i=0; add <= n; i++){
            answer[i] = add;
            add += 2;
        }
        
        return answer;
    }
}