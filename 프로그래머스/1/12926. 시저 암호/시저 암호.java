class Solution {
    public String solution(String s, int n) {
        // 문자를 정수(아스키코드)로 바꾸고 n을 더한 후에, 나머지 연산으로 a로 돌아오게
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
               sb.append((char)(((c-'A'+n) % 26)+'A'));
            } else if(Character.isLowerCase(c)){
                sb.append((char)(((c-'a'+n) % 26)+'a'));
            } else if(c == ' '){
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}