package com.example.cotServer01.controller;

import com.example.cotServer01.domain.User;
import com.example.cotServer01.dto.PageResponseDTO;
import com.example.cotServer01.dto.UserRequestDTO;
import com.example.cotServer01.dto.UserResponseDTO;
import com.example.cotServer01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User관련 HTTP요청처리 Controller
 */

@RestController //REST API응답을 위한 controller
@RequestMapping("/api/users") //기본 URL경로설정
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 사용자 등록(test)
     * @param user (JSON객체)
     * @return
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        //JSON으로 데이터 받고 User객체로 전환
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);    //HTTP 200 OK + 저장된사용자 반환
    }

    /**
     * 사용자명(userName)로 사용자 단건 조회
     * @param userName
     * @return
     */
    @GetMapping("/{userName}")   //GET방식, /users/{userName}로 요청 처리 예정
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        //PathVariable은 URI경로값을 파라메터로 바인딩
        return userService.findByUserName(userName)
                .map(ResponseEntity::ok) //Optional에 값이 있으면 HTTP 200 OK + 사용자
                .orElse(ResponseEntity.notFound().build()); //값이 없으면 HTTP 404 리턴

    }

    /**
     * userRole입력으로 사용자 목록 조회
     * @param userRole
     * @return
     */
    @GetMapping("role/{userRole}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String userRole) {
        List<User> users = userService.findByUserRole(userRole);
        return ResponseEntity.ok(users);    //HTTP 200 OK + 사용자 리스트 리턴
    }

    /**
     * createUser(userRequestDto)
     */
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO reqDto) {
        return ResponseEntity.ok(userService.createUser(reqDto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long userId, @RequestBody UserRequestDTO reqDto) {
        return ResponseEntity.ok(userService.updateUser(userId, reqDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public ResponseEntity<PageResponseDTO<UserResponseDTO>> findPage(Pageable pageable) {
        return ResponseEntity.ok(userService.getUserPage(pageable));
    }
}
