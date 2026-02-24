import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        // UTC 시간대를 기준으로 현재 시간 가져오기
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);

        // 형식에 맞춰 출력 (연, 월, 일 순서로 줄바꿈)
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue()); // getMonth()는 영문(JANUARY 등)을 반환하므로 주의!
        System.out.println(now.getDayOfMonth());
    }
}