class Solution {
    public int solution(int left, int right) {
        // left ~ right 반복문
        // 수 하나를 고르고
        // 그 수 약수 갯수 카운팅하고
        // 홀짝 구분
        int answer = 0;
        for(int i=left; i<=right; i++){
            int cnt = 0;
            for(int j=1; j<=i; j++)
                if(i % j == 0) cnt++;
            if(cnt % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
}