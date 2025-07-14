package org.example.chapter12;

/*
* === MVC 패턴
* : Model(모델), View(뷰), Controller(컨트롤러)
* - 사용자가 인터페이스를 설계하는 소프트웨어 디자인 패턴 중 하나
* - 세 가지 구성 요소로 나누어 개발을 진행 (역할 분담)
* 
* cf) 디자인 패턴: 소프트웨어 디자인 과정에서 자주 발생하는 문제들에 대한 일반적인 해결책
* 
* 1. Model(모델)
*       : 애플리케이션에 데이터와 비즈니스 로직을 담당
*       - DB, 파일 시스템, 외부 서비스와의 통신을 통해 데이터를 저장하고 검색
*       - 상태 변경에 대해 View와 Controller에 알릴 수 있는 매커니즘을 제공
*       >> View와 Controller의 세부 구현사항으로부터 독립적
*
* 2. View(뷰)
*       : 사용자에게 데이터를 표시하는 방법을 정의
*       - Model의 정보를 표시, 사용자 액션을 Controller 에게 전달
*       - Model이 가진 정보를 사용자가 이해할 수 있는 형태로 변환
* 
* 3. Controller(컨트롤러)
*       : 사용자의 입력을 처리하고, Model과 View 사이의 상호작용을 관리
*       - 사용자의 입력에 반응하여 Model을 업데이트하고, 필요한 경우 View를 새롭게 출력
* 
* == MVC 패턴 장점 ==
* - 역할 분담
*       : 각 구성 요소가 독립적인 기능을 책임 > 코드 관리 & 확장 용이
* 
* - 유지보수 용이
*       : 애플리케이션의 비즈니스 로직과 사용자 인터페이스(User Interface)가 분리되어 유지보수가 쉬움
* 
* == MVC 패턴 단점 ==
* - 복잡성 증가
*       : 간단한 애플리케이션 구현에는 MVC 패컨 구조가 복잡성을 증가시킴
* - 학습 곡선이 높음
*       : 이해하고 사용하기까지 일정한 학습이 필요
*
* == MVC 패턴의 작동 원리
* View >> Controller >> Model >> Controller >> View
* 
* cf) Spring: 자바 기반 웹 프레임워크
*       >> Spring Boot (Spring MVC)
* */

public class MVC {
    public static void main(String[] args) {
        
    }
}
