import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
         for (String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int sum = 1;
        for(int cnt : map.values()){
            sum *= (cnt + 1);
        }
        
        return sum -1; // 다 벗는 경우 제외
    }
}