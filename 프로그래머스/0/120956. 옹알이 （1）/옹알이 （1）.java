class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        String temp = "";
        
        for(String i : babbling){
            for(String j : word){
                if(i.contains(j)){
                    temp = i.replace(j, " ");
                    i = temp;
                }
            }
            if(i.isBlank())
                answer++;
        }
        
     
        
        return answer;
    }
}