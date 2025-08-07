class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        boolean before_num = false;
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            
            if(Character.isDigit(c)){
                before_num = true;
                temp.append(c);
            } else{
                if(temp.length() > 0){
                     before_num = false;
                    String str = temp.toString();
                    answer += Integer.parseInt(str);
                      temp.setLength(0);
                }
              
            }
        }
        
    
        if (temp.length() > 0) {
            answer += Integer.parseInt(temp.toString());
        }
        
        return answer;
    }
}