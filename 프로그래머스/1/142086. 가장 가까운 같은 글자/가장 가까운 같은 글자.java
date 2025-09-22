class Solution {
    public int[] solution(String s) {
        // -1로 초기화 해놓고
        // 문자 하나 고르고
        // 0까지 뒤로 확인 하나씩 하면서 count하고
        // 발견하면 count 쓰기
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int cnt = 0;
            boolean isDup = false;
            for(int j=i-1; j>=0; j--){
                char temp = s.charAt(j);
                if(temp == c){
                    cnt++;
                    isDup = true;
                    break;
                } else cnt++;
            }
            if(isDup) answer[i] = cnt;
            else answer[i] = -1;
        }
        return answer;
    }
}