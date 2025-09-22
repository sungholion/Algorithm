class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++){
            for(int j=0; j<food[i]/2; j++)
                sb.append(i).append("");
        }
        sb.append("0");
         for(int i=food.length-1; i>= 1; i--){
            for(int j=0; j<food[i]/2; j++)
                sb.append(i).append("");
        }
        
        return sb.toString();
    }
}