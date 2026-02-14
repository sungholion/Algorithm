class Solution {
    public int solution(int n, String control) {
        int answer = n;
        
        for(int i = 0; i < control.length(); i++){
            char order = control.charAt(i);
            if(order == 'w') answer++;
            else if(order == 's') answer--;
            else if(order == 'd') answer += 10;
            else answer -= 10;
        }
        
        return answer;
    }
}