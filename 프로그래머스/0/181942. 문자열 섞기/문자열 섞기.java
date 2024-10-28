class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        
        int l = str1.length();
        
        for(int i=0; i<l; i++){
            answer += str1.charAt(i) + "" + str2.charAt(i);
        }
        
        return answer;
    }
}