class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        
        int len = phone_number.length();
        
        for(int i = 0; i < len - 4; i++) sb.append("*");
        for(int i = len - 4; i < len; i++) sb.append(phone_number.charAt(i));
        return sb.toString();
    }
}