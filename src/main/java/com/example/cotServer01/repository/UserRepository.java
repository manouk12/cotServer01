package com.example.cotServer01.repository;

import com.example.cotServer01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//User 엔티티용 JPA Repository Interface
//JpaRepository<User, Long> -> <엔티티 클래스, PK타입>
public interface UserRepository extends JpaRepository<User, Long> {
    //사용자명으로 조회 메소드
    //Optional<User> -> JPA가 보고 자동으로 쿼리 생성(메서드 쿼리방식)
    Optional<User> findByUserName(String userName);

    //사용자 권한으로 목록 조회
    List<User> findByUserRole(String userRole);

}
