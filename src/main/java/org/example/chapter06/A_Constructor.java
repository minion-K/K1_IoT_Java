package org.example.chapter06;

// === 생성자(Constructor) ===
// : 객체(인스턴스)가 생성될 때 호출되는 '인스턴스 초기화 메서드'

// - 생성자 조건
//      : 클래스명과 동일한 이름을 사용
//      : 리턴값이 없는 메서드 형식(void 타입이 생략)

// '컴파일러가 제공하는 기본 생성자'
// : 클래스에 생성자가 없으면 자동 생성되는 빈 생성자
//  >> 매개변수 X, 아무런 작업도 하지 않음 (구현부 내의 코드가 없음)

class Example1{
    int value;

//    기본 생성자 생략
//    Example1() {}
}

class Example2 {
    int value;

    Example2(int value){
        this.value = value;
    }
}
public class A_Constructor {
    public static void main(String[] args) {

    }
}
