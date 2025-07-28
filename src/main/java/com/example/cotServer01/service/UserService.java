package com.example.cotServer01.service;

import com.example.cotServer01.domain.User;
import com.example.cotServer01.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 사용자 관련 비즈니스 로직 담당 서비스 Class
 */

@Service    //스프링 컴포넌트로 등록(자동 빈 생성)
@RequiredArgsConstructor    //생성자 주입 자동 처리(final필드만)
public class UserService {
    private final UserRepository userRepository;    //의존성 주입

    /**
     * 사용자 저장(회원가입 등)
     * @param user 저장할 사용자 엔티티
     * @return 저장된 사용자
     */
    public User saveUser(User user) {
        //TODO : 중복체크, 비밀번호 암호화 등의 로직 추가 예정
        return userRepository.save(user);
    }

    /**
     * userName으로 사용자 조회
     * @param userName
     * @return Optional<User>
     */
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    /**
     * userRole로 전체 목록 조회
     * @param userRole (admin,user등)
     * @return List<User>
     */
    public List<User> findByUserRole(String userRole) {
        return userRepository.findByUserRole(userRole);
    }
}
