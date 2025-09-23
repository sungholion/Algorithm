class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        for(int i=0; i<n; i++){
            char ch = name.charAt(i);
            int num = ch - 'A';
            answer += Math.min(num, 26-num);
        }
        
        int move = n - 1;   // 오른쪽으로 끝까지
        for(int i=0; i<n; i++){
            int j = i + 1;
            
            while(j < n && name.charAt(j) == 'A') j++;
            
            int goAndBack = i + i + (n - j);
            int backAndGo = (n - j) + (n - j) + i;

            move = Math.min(move, Math.min(goAndBack, backAndGo));
        }
        
        return answer + move;
    }
}