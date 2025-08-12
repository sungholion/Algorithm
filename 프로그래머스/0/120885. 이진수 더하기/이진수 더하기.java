class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        // bin1과 bin2를 받아서 10진수로 바꾸고
        // 바꾼 결과를 이진수로 바꿔서 String으로 반환
        // 문자열 끝에서부터 곱하기
        
        int x = 1;
        int res = 0;
        for(int i=bin1.length()-1; i>=0; i--){
            char c = bin1.charAt(i);
            int num = c - '0';
            res += num * x;
            x *= 2;
        }
        
        x = 1;
        for(int i=bin2.length()-1; i>=0; i--){
            char c = bin2.charAt(i);
            int num = c - '0';
            res += num * x;
            x *= 2;
        }
        
        answer = Integer.toBinaryString(res);
        
        return answer;
    }
}