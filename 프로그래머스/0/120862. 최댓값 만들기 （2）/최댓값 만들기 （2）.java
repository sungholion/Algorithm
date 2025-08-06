class Solution {
    public int solution(int[] numbers) {
        int big = numbers[0] * numbers[1];
        
        for(int i=0; i<numbers.length - 1; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i] * numbers[j] > big)
                    big = numbers[i] * numbers[j];
            }
        }
        return big;
    }
}