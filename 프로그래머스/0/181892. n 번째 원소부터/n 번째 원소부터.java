class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        int answer_len = len - n + 1;
        int[] answer = new int[answer_len];
        for(int i = 0; i < answer_len; i++){
            answer[i] = num_list[i+n-1];
        }
        return answer;
    }
}