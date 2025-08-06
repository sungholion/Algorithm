class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] temp = new int[numlist.length];
        
        int cnt = 0;
        for(int i=0; i<numlist.length; i++){
            if(numlist[i] % n == 0){
                temp[cnt++] = numlist[i];
            }
        }
        
        int[] answer = new int[cnt];
        for(int i = 0; i<cnt; i++){
            answer[i] = temp[i];
        }
        
        return answer;
    }
}