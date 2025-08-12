class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length() / n;
        if(my_str.length() % n != 0)
            len++;
        String[] answer = new String[len];
        StringBuilder sb;
        
        int idx = 0;
        for(int i=0; i<len; i++){
            sb = new StringBuilder();
            for(int j=0; j<n && (idx + j) < my_str.length(); j++){
                char c = my_str.charAt(idx + j);
                sb.append(c);
            }
            idx+= n;
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}