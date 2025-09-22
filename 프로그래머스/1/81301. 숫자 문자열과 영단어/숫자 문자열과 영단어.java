class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) sb.append(c);
            else{
                if(c == 'z'){
                    sb.append(0);
                    i+= 3;
                } else if(c == 'o'){
                    sb.append(1);
                    i+= 2;
                } else if(c == 't' && s.charAt(i+1) == 'w'){
                    sb.append(2);
                    i+=2;
                } else if(c == 't' && s.charAt(i+1) == 'h'){
                    sb.append(3);
                    i+=4;
                } else if(c == 'f' && s.charAt(i+1) == 'o'){
                    sb.append(4);
                    i+=3;
                } else if(c == 'f' && s.charAt(i+1) == 'i'){
                    sb.append(5);
                    i+=3;
                } else if(c == 's' && s.charAt(i+1) == 'i'){
                    sb.append(6);
                    i+=2;
                } else if(c == 's' && s.charAt(i+1) == 'e'){
                    sb.append(7);
                    i+=4;
                } else if(c == 'e'){
                    sb.append(8);
                    i+=4;
                } else if(c == 'n'){
                    sb.append(9);
                    i+=3;
                } 
            }
        }
        return Integer.parseInt(sb.toString());
    }
}