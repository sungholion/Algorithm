class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<rsp.length(); i++){
            char c = rsp.charAt(i);
            if(c == '2')
                sb.append("0");
            else if(c == '0')
                sb.append("5");
            else 
                sb.append("2");
        }
        return sb.toString();
    }
}