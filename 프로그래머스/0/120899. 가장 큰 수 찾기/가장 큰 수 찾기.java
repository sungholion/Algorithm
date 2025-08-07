class Solution {
    public int[] solution(int[] array) {
        int max = -1;
        int max_idx = -1;
        
        for(int i=0; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
                max_idx = i;
            }    
        }
        
        return new int[] {max, max_idx};
    }
}