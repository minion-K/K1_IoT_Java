package org.example.chapter09_practice;

/*
* === 사용자 user에 대한 관리 시스템 구현 ===
* : 사용자 정보를 관리
* - 사용자 생성 및 수정 등을 처리
* - 생성 및 수정 시 생성일, 수정일 기록 - DateUtil 사용
* 
* 1) 요구 사항
* User 클래스
* - 필드: id(사용자고유번호), name, email, createdAt, updatedAt
* - 생성자: createdAt 값을 설정 (+ 정보 수정 시 updatedAt 설정)
* - 메서드: toString() 메서드 오버라이딩하여 사용자 정보 출력
* 
* DateUtil '유틸' 클래스
* - 메서드: 현재 날짜 및 시간을 yyyy-MM-dd HH:mm:ss 형식으로 반환(getCurrentDateTime())
* 
* UserService 인터페이스
* - 사용자 추가, 조회(단건, 전체), 수정
* 
* UserServiceImpl 클래스 (implements)
* - ArrayList<User>를 사용하여 사용자 목록 관리
* - 존재하지 않는 id로 조회, 수정하는 경우 사용자 정의 예외 발생
* 
* UserNotFoundException '예외' 클래스
* - 메시지를 받아 출력하는 사용자 정의 예외
* 
* Main 클래스: 프로그램 실행의 진입점
* - UserServiceImpl를 인스턴스화 하여 동작을 실행
* 
* */

// cf) model
//  : 정보(데이터)를 담는 틀
// EX) 학생 정보를 저장
//      'Student' 라는 클래스 모델이 있고,
//      해당 모델 내에 이름, 나이, 학번 등이 포함

// cf) service
// : 일을 처리하는 곳
// EX) 학생 등록하기, 학생 정보 가져오기, 학생 삭제하기 등을 처리
//      >> model을 가지고 일을 하는 곳


import org.example.chapter09_practice.exception.UserNotFoundException;
import org.example.chapter09_practice.model.User;
import org.example.chapter09_practice.service.UserService;
import org.example.chapter09_practice.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        == 로직 실행 ==
        UserService userService = new UserServiceImpl();

//        사용자 추가
        userService.addUser(new User(1, "권민현", "qwe123@example.com"));
        userService.addUser(new User(2, "안미향", "asd456@example.com"));
        userService.addUser(new User(3, "김승민", "zxc789@example.com"));

//        사용자 조회(전체)
        List<User> users = userService.getAllUsers();
        for(User user: users) {
            System.out.println(user.toString());
        }
        
//        이메일 수정
        try {
            userService.updateUserEmail(1,"asd000@example.com");
        } catch (UserNotFoundException e) {
            System.out.println("수정 실패" + e.getMessage());
        }

//        사용자 조회(단건)
        User user = userService.getUserById(1);
        System.out.println(user);

//        존재하지 않는 사용자 검색(예외 발생 테스트)
        try{
            userService.getUserById(100);
        } catch (UserNotFoundException e) {
            System.out.println("조회 실패: " + e.getMessage()); // 조회 실패: 사용자 ID에 100값이 없습니다.
        }
    }
}
