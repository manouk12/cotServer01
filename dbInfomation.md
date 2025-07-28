# 📦 cotServer01 — 실무형 백엔드 프로젝트 스터디

## ✅ 프로젝트 개요

Spring Boot 기반의 B2B 백오피스 시스템 + AWS S3 이미지 업로드 기능을 통합한 실무형 백엔드 프로젝트입니다.  
이력서 및 포트폴리오 용도로 제작되며, 실제 기업에서 사용 가능한 수준을 목표로 합니다.

---

## 🧩 주요 기능

- 관리자 로그인 및 인증 (Spring Security + JWT or 세션)
- 사용자 / 상품 / 주문 관리 CRUD
- 이미지 업로드 (AWS S3 연동)
- 이미지 삭제 / 목록 API
- Swagger 기반 API 문서 자동화
- (선택) React or Thymeleaf 연동 UI

---

## ☁️ 사용 기술 스택

- **Spring Boot 3.x**
- **Spring Security**
- **JPA (Hibernate)**
- **MySQL / MariaDB**
- **AWS S3**
- **Swagger / Postman**
- **Docker**
- (선택) React, Thymeleaf 등

---

## 📁 프로젝트 디렉토리 구조 (예시)

src
└─ main
├─ java
│ └─ com.example.cotServer01
│ ├─ config # 설정 (보안, WebConfig 등)
│ ├─ controller # API 컨트롤러
│ ├─ domain # JPA Entity
│ ├─ dto # 요청/응답 DTO
│ ├─ repository # Spring Data JPA 인터페이스
│ ├─ service # 비즈니스 로직
│ └─ util # 유틸리티 (파일 처리 등)
└─ resources
├─ application.yml
└─ static / templates

---

## 🛠️ 개발 진행 순서

1. 프로젝트 구조 구성 및 ERD 설계
2. Entity / Repository / Service(비즈니스 로직 계층) / Controller 구현
3. AWS S3 연동 및 이미지 처리 기능 추가
4. API 문서화 및 테스트 케이스 작성
5. (선택) 프론트엔드 UI 연동 및 배포

---

## 👨‍💻 개발자

- **개발자**: 이만욱
- **경력**: Java 기반 SI/SM 개발 경력 6년 이상
- **목표**: 자사 서비스 기반 실무 중심 개발자 전환