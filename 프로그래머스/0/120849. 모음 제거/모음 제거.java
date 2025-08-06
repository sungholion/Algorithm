class Solution {
    public String solution(String my_string) {
        String str = "a,e,i,o,u";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++){
            boolean is_cons = true;
            for(int j=0; j<str.length(); j++){
                if(my_string.charAt(i) == str.charAt(j))
                    is_cons = false;
            }
            if(is_cons)
                sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}