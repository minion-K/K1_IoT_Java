package org.example.chapter09_practice.service;

import org.example.chapter09_practice.model.User;

import java.util.List;

public interface UserService {
//    인터페이스의 특징
//    내부의 멤버(변수, 메서드)는 각각 public static final, public abstract이 생략
    
//    1. 사용자 등록(추가)
//    요청값: 사용자 정보, 반환값: X
    void addUser(User user);

//    2. 사용자 조회(단건)
//    요청값: 사용자 특정 값, 반환값: 단일 사용자 정보
    User getUserById(int id);
    
//    3. 사용자 조회(전체)
//    요청값: X, 반환값: 정체 사용자 정보(배열)
    List<User> getAllUsers();

//    4. 사용자 수정
//    요청값: 사용자 특정값, 새로운 이메일값, 반환값: X
    void updateUserEmail(int id, String newEmail);
}
