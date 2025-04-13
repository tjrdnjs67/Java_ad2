package annotation.basic;

import util.MyLogger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
애노테이션 정의 규칙
- 기본 타입(int, float, boolean 등)
- String
- Class (메타데이터) 또는 인터페이스
- enum
- 다른 애노테이션 타입
- 위의 타입들의 배열
- 앞선 타입 외에 일반적인 클래스(사용자가 정의한)는 사용할 수 없음

default 값
- 요소에 default 값 지정 가능
- 예 : String value() default "기본 값을 적용합니다.";

요소 이름
- 메서드 형태로 정의
- 괄호()를 포함하되 매개변수는 없어야 함

반환 값
- void 타입 사용 불가

예외
- 예외 선언할 수 없음

 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnoElement {
    String value();
    int count() default 0;
    String[] tags() default {};

    // MyLogger data(); 직접 만든 타입은 선언할 수 없음
    Class<? extends MyLogger> annoData() default MyLogger.class; // 클래스로 직접 만든 타입 선언 가능
}
