package com.example.cotServer01.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 사용자정보(User) JPA Entity Class
 * 관리자의 로그인 계정으로 사용
 * 추후 일반 사용자 확장 고려
 */

@Entity //JPA에서 관리되는 엔티티 명시(DB테이블로 매핑)
@Table(name = "users") //생성된 테이블 명을 users로 지정. 테이블명이 여기에 명시되는거 주의

//Lombok관련 어노테이션
@Builder //Builder 패턴 사용 명시
@Getter
@Setter
@NoArgsConstructor //파라메터 없는 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 파라메터로 받는 생성자 생성

public class User {
    // userId (자바 필드명) ↔ user_id (DB 컬럼명)
    // 자바는 camelCase, DB는 snake_case 사용 → @Column으로 명시적 매핑

    @Id //해당 필드가 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    //기본키 값을 DB내에서 자동 증가하도록 설정(MySQL의 AUTO_INCREMENT와 같은 역할)
    private Long userId;

    @Column(name = "user_name", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "user_pw", nullable = false)
    private String userPw;

    @Column(name = "user_role", length = 20)
    private String userRole;

    @Column(name = "created_dt", nullable = false)
    private LocalDateTime createdDt;

    @PrePersist
    //엔티티가 저장되기 전(PrePersist) 자동실행 메소드
    protected void onCreate() {
        this.createdDt = LocalDateTime.now();
    }
}
