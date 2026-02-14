class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        int ans_len = len / n;
        if(len % n != 0) ans_len++;
        int[] answer = new int[ans_len];
        int idx = 0;
        for(int i = 0; i < len; i+= n){
            answer[idx++] = num_list[i];
        }
        
        return answer;
    }
}