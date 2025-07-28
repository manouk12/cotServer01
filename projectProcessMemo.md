# cotServer01 - 사용자 관리 기능 개발 구조 정리

2025.07.29 Init By 이만욱

## 🧱 프로젝트 목적
- 사내 관리자 시스템(B2B 백오피스)을 위한 사용자 관리 API 구현
- 사용자 등록 / 조회 / 수정 / 삭제 기능 포함
- 추후 로그인, 파일업로드, JWT 등 확장 예정

---

## 🧭 개발 순서 요약

### ✅ 1. User 엔티티 생성
- 📄 `User.java`
    - JPA 기반 사용자 테이블 매핑용 엔티티
    - 필드: id, userName, userPw, userRole

### ✅ 2. UserRepository 생성
- 📄 `UserRepository.java`
    - JpaRepository 상속
    - 기본 CRUD 사용 가능

### ✅ 3. DTO 생성
- 📄 `UserRequestDto.java`
    - 사용자 등록/수정 요청용 DTO
- 📄 `UserResponseDto.java`
    - 사용자 응답 반환용 DTO

### ✅ 4. UserService 작성
- 📄 `UserService.java`
    - 비즈니스 로직 담당
    - 엔티티 ↔ DTO 변환 처리
    - 사용자 등록, 조회, 수정, 삭제 기능 포함

### ✅ 5. UserController 작성
- 📄 `UserController.java`
    - REST API 엔드포인트 구현
    - URL 기반으로 메서드 분리 (@PostMapping, @GetMapping 등)
    - 요청 DTO 받고, 응답 DTO 반환
    - 
### ✅ 6. 사용자목록 페이징 처리
- 📄 `PageResponseDTO.java`
  - 공통단으로 사용할 페이징

### ✅ 7. 예외처리
- 📄 `cotServer01/exception`
  - DTO, Handler 추가

### ✅ 8. CORS설정
- 📄 `cotServer01/config`
  - 개발용으로 작업 시 allowedOrigins("*")사용. 운영에서 사용 금지

### ✅ 9. 비밀번호 암호화
- 📄 `BCrypt`
  - 인증 시, 평문 비번을 매치 확인만
  - 라이브러리 추가(스프링부트 스타터-security내에 포함)


---

## 🔁 흐름 구조 요약

클라이언트 요청 → Controller → Service → Repository → DB
↓ ↓
RequestDTO ResponseDTO

---

## 🌐 REST API 구성 요약

| 메서드 | URL | 설명 |
|--------|-----|------|
| POST   | `/api/users`      | 사용자 등록 |
| GET    | `/api/users`      | 사용자 전체 조회 |
| GET    | `/api/users/{id}` | 사용자 단건 조회 |
| PUT    | `/api/users/{id}` | 사용자 수정 |
| DELETE | `/api/users/{id}` | 사용자 삭제 |

---

## 사용자 목록 페이징 처리
- 공통으로 처리하도록 PageResponseDTO로 빼놓음

---

## 예외처리
 - conServer01/exception 폴더 내
 - DTO, Handler 추가

---

## CORS설정
 *CORS(Cross-Origin Resourece Sharing)
    스터디 목적으로 허용

 - conServer01/config 폴더 내
 - 개발용으로 작업 시 allowedOrigins("*")사용. 운영에서 사용 금지

---

## 비밀번호 암호화 BCrypt
 - 인증 시, 평문 비번을 매치 확인만 
 - 라이브러리 추가(스프링부트 스타터-security내에 포함)

## 📌 다음 개발 예정 항목
- 사용자 목록 페이징 처리
- 비밀번호 암호화 (BCrypt)
- 예외 처리 통합 (@ControllerAdvice)
- Swagger API 명세 적용
- 로그인 + JWT 인증
- AWS S3 이미지 업로드 연동

---