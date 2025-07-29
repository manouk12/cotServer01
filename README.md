# cotServer01

사내 관리자 시스템을 위한 Spring Boot 백엔드 API 서버(Spring boot)

## 주요 기능
- 사용자 등록 / 수정 / 삭제 / 조회
- 페이징 처리
- 비밀번호 암호화 (BCrypt)
- 예외 처리 통합 (@ControllerAdvice)
- CORS 설정
- React 프론트와 연동 예정

## 기술 스택
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL (Docker)
- Maven
- IntelliJ Community

## 실행 방법
```bash
# 1. MySQL 컨테이너 실행
docker run --name cot-db -e MYSQL_ROOT_PASSWORD=1234 -p 3306:3306 -d mysql:8

# 2. 프로젝트 실행
./mvnw spring-boot:run
