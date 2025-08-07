class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num1; i++)
            sb.append(my_string.charAt(i));
        sb.append(my_string.charAt(num2));
        for(int i=num1+1; i<num2; i++)
            sb.append(my_string.charAt(i));
        sb.append(my_string.charAt(num1));
        for(int i=num2+1; i<my_string.length(); i++)
            sb.append(my_string.charAt(i));
        return sb.toString();
        
    }
}