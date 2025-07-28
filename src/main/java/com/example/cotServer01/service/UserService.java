package com.example.cotServer01.service;

import com.example.cotServer01.domain.User;
import com.example.cotServer01.dto.PageResponseDTO;
import com.example.cotServer01.dto.UserRequestDTO;
import com.example.cotServer01.dto.UserResponseDTO;
import com.example.cotServer01.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 사용자 관련 비즈니스 로직 담당 서비스 Class
 */

@Service    //스프링 컴포넌트로 등록(자동 빈 생성)
@RequiredArgsConstructor    //생성자 주입 자동 처리(final필드만)
public class UserService {
    private final UserRepository userRepository;    //의존성 주입

    //BCrypt추가
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

    /**
     * createUser(userRequestDto)
     * return userResponseDTO
     */
    public UserResponseDTO createUser(UserRequestDTO reqDto) {
        User user = User.builder()
                .userName(reqDto.getUserName())
                //.userPw(reqDto.getUserPw())
                .userPw(passwordEncoder.encode(reqDto.getUserPw())) //pw 암호화
                .userRole(reqDto.getUserRole())
                .build();
         User saved = userRepository.save(user);

         return new UserResponseDTO(saved.getUserId(), saved.getUserName(), saved.getUserRole());
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(u-> new UserResponseDTO(u.getUserId(), u.getUserName(), u.getUserRole()))
                .collect(Collectors.toList());
    }

    /**
     * getUser(find an user)
     * @param userId
     * @return
     */
    public UserResponseDTO getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("There is no User"));
        return new UserResponseDTO(user.getUserId(), user.getUserName(), user.getUserRole());
    }

    @Transactional
    public UserResponseDTO updateUser(Long userId, UserRequestDTO reqDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("There is no User"));
        user.setUserName(reqDto.getUserName());
        //user.setUserPw(reqDto.getUserPw());
        user.setUserPw(passwordEncoder.encode(reqDto.getUserPw()));
        user.setUserRole(reqDto.getUserRole());
        return new UserResponseDTO(user.getUserId(), user.getUserName(), user.getUserRole());
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public PageResponseDTO<UserResponseDTO> getUserPage(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        Page<UserResponseDTO> dtoPage = users.map(u->new UserResponseDTO(u.getUserId(), u.getUserName(), u.getUserRole()));
        return PageResponseDTO.of(dtoPage);
    }

}
