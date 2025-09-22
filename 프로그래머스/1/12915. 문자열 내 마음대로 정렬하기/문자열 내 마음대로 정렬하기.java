class Solution {
    public String[] solution(String[] strings, int n) {
        for(int i=0; i<strings.length-1; i++){
            for(int j=i+1; j<strings.length; j++){
                String str1 = strings[i];
                String str2 = strings[j];
                String temp = "";
                char c1 = str1.charAt(n);
                char c2 = str2.charAt(n);
                if(c1 > c2 || (c1 == c2 && str1.compareTo(str2) > 0)){
                    temp = str2;
                    strings[j] = str1;
                    strings[i] = temp;
                }
            }
        }
        
        return strings;
    }
}