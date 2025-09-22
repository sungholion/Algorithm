class Solution {
    public int solution(String t, String p) {
        // t의 문자를 처음부터 끝까지 보면서
        // p 길이만큼 부분 문자열 조합하고 비교
        int lenP = p.length();
        int lenT = t.length();
        long numP = Long.parseLong(p);
        int answer = 0;
        
        for(int i=0; i<=lenT-lenP; i++){
            String temp = t.substring(i, i+lenP);
            long numT = Long.parseLong(temp);
            if(numT <= numP) answer++;
        }
        return answer;
    }
}