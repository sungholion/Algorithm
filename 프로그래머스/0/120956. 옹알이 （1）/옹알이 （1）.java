class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(String now : babbling) {
            now = now.replaceFirst("aya", "0");
            now = now.replaceFirst("ye", "0");
            now = now.replaceFirst("woo", "0");
            now = now.replaceFirst("ma", "0");
            now = now.replaceAll("0", "");

            if(now.isEmpty()) answer++;
        }

        return answer;
    }
}