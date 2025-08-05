class Solution {
    public int[] solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        
        for(int x : num_list){
            if(x % 2 != 0)
                odd++;
            else
                even++;
        }
        
        return new int[] {even, odd};
    }
}