class Solution {
    public String solution(String s) {
        int len = s.length();
        String str = "";
        
        if(len % 2 == 1) return str + s.charAt(len/2);
        else return str + s.charAt(len/2 - 1) + s.charAt(len/2);
    }
}