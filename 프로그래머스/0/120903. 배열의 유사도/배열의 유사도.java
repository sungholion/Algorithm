class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String s1_str : s1){
            for(String s2_str : s2){
                if(s1_str.equals(s2_str)){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}