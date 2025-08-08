class Solution {
    public int solution(int[] array, int n) {
        int near = Math.abs(n - array[0]);
        int near_value = array[0];
        
        for(int i=1; i<array.length; i++){
            int x = Math.abs(n - array[i]);
            if(near > x){
                near = x;
                near_value = array[i];
            } else if(near == x && near_value > array[i]){
                near_value = array[i];
            }
                
        }
        
        return near_value;
    }
}