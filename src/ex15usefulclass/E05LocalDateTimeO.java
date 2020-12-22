package ex15usefulclass;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class E05LocalDateTimeO {

	public static void main(String[] args) {

		//현재 시간의 정보를 저장. 파일 마지막에서 확인
		Instant start = Instant.now();
		
		//오늘 날짜
		LocalDate nowDate=LocalDate.now();
		System.out.println("오늘날짜: "+nowDate);
		
		//특정날짜 1989년 10월 04일
		LocalDate ofDate=LocalDate.of(1989, 10, 4);
		System.out.println("생년월일: "+ofDate);
		
		//현재 날짜와 시간
		LocalDateTime nowDateTime=LocalDateTime.now();
		System.out.println("지금 이 순간: "+nowDateTime);
		
		//특정날짜와 시간 지정
		LocalDateTime ofDateTime=LocalDateTime.of(1989, 10, 4, 4, 58, 32);
		System.out.println("생년월일과 시간: "+ofDateTime);
		
		//오늘 날짜의 자정
		DateTimeFormatter formatter=
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		String dateStr=LocalDate.now().atStartOfDay().format(formatter);
		System.out.println("금일 자정: "+dateStr);
		
		//내일날짜
		LocalDate tomorrow=nowDate.plusDays(1);
		System.out.println("내일: "+tomorrow);
		
		//3일 후의 정오(오후 12시)
		LocalDateTime day3Later=LocalDateTime.now().plusDays(3).with(LocalTime.NOON);
		System.out.println("3일 후 12시: "+day3Later);
		
		//앞으로 2시간 10분 후
		System.out.println("2시간 10분 후: "+nowDateTime.plusHours(2).plusMinutes(10));
		
		//가장 가까운 요일, N번째 요일 등을 간단한 코드로 가져올 수 있다.
		LocalDateTime nowSunday=LocalDateTime.now()
				.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("가장 가까운 다음 일요일: "+nowSunday);
		
		LocalDate fourthSunday=LocalDate.of(2020, 3, 1)
				.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.SUNDAY));
		System.out.println("2020년 3월 기준, 네 번째 일요일: "+fourthSunday);
		
		LocalDate firsth12Sunday=LocalDate.of(2020, 3, 1)
				.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
		System.out.println("2020년 3월 기준, 첫 번째 일요일: "+firsth12Sunday);
		
		LocalDate xmas=LocalDate.of(LocalDate.now().getYear(), 12, 25);
		Period left=Period.between(nowDate, xmas);
		System.out.println("X-mas까지 앞으로: "
				+left.getMonths()+"개월"+left.getDays()+"일");
		
		Instant end = Instant.now();
		Duration duration=Duration.between(start, end);
		System.out.println("클래스 실행 시간 확인(두 시간 차): "+duration.toMillis());
		
		System.out.println("현재 월을 영문으로 표시: "+nowDate.getMonth());
		
		
	}

}
