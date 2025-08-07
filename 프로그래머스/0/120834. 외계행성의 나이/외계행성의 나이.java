class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String age_str = age + "";
        
        for(int i=0; i<age_str.length(); i++){
            int num = age_str.charAt(i) - '0';
            char c = (char) (num + 'a');
            sb.append(c);
        }
        
        return sb.toString();
    }
}