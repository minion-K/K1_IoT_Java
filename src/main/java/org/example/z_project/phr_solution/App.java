package org.example.z_project.phr_solution;

/**
 * === PHR (개인 건강 기록, Personal Health Record) 솔루션 ===
 * 
 * 1. 프로젝트 개요
 *  - 개인 건강 기록인 PHR 솔루션을 위한 간단한 콘솔 기반 응용 프로그램
 *  - 환자의 기본 정보를 관리, 환자의 건강 기록 등록, 수정, 조회 가능
 *  - 특정 조건에 따라 맞는 건강 기록을 필터링하고 집계 가능
 *
 *  2. 주요 기능 & 비즈니스 로직
 *  - 환자 정보 관리(Patient): CR(단건/전체)UD
 *  - 건강 기록 관리(HealthRecord): CRUD + 필터링(조회)
 *
 * 3. 비즈니스 로직 구조
 * - controller: 사용자 입력 처리 + 알맞은 서비스 메서드 호출
 * - service: 핵심 비즈니스 로직 수행
 * - repository: 데이터 저장소(DB)와의 상호작용 담당
 * - dto: 계층 간 데이터 전송을 위한 객체
 * - entity: 데이터 저장소(DB)의 테이블과 매핑(연결)되는 도메인 객체
 * 
 * 4. 실행 및 관리
 * - App.java: 프로그램 실행에 대한 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어
 */


public class App {
    public static void main(String[] args) {
        
    }
}
