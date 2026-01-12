import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for(int i = 0; i < completion.length; i++){
            int cnt = map.get(completion[i]);
            if(cnt > 1) map.put(completion[i], cnt - 1);
            else map.remove(completion[i]);
        }
        
        for(String name : map.keySet()){
            return name;
        }
        
        return "";
        
    }
}