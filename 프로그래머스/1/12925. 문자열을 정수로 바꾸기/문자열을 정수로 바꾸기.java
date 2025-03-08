class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.charAt(0) == '-'){
            String temp = "";
            for(int i=1; i<s.length(); i++){
                temp += s.charAt(i);
            }
            answer = Integer.parseInt(temp);
            answer *= -1;
        } else {
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}