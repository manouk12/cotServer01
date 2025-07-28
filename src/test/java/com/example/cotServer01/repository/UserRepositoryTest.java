package com.example.cotServer01.repository;


import com.example.cotServer01.domain.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

//@DataJpaTest    //JPA Repository 테스트 전용 어노테이션
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(false)
    @DisplayName("사용자 저장 및 조회 테스트")
    void testSaveAndFindByUserName() {
        //given
        User user = User.builder()
                .userName("testuser")
                .userPw("1234")
                .userRole("USER")
                .build();
        userRepository.save(user);

        // when
        // 사용자명으로 사용자 조회(DB select)
        Optional<User> result = userRepository.findByUserName("testuser");

        // then
        // 조회 결과가 존재하는지 확인(isPresent()는 Optional이 비어있지 않음)
        assertThat(result).isPresent();
        // 조회된 사용자의 이름이 기대한 값과 일치하는지 확인
        assertThat(result.get().getUserName()).isEqualTo("testuser");
    }
}
