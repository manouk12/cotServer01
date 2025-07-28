# 🧬 ERD 설계 문서

cotServer01 프로젝트의 핵심 도메인(Entity) 설계 문서 
각 테이블은 JPA Entity로 구현되며, DB 테이블과 일대일로 매핑

2025.07.27 초안

---

## 📌 테이블 요약

| 테이블 이름     | 설명                         |
|----------------|------------------------------|
| User           | 사용자 계정 정보              |
| Product        | 상품 정보                     |
| ImageFile      | 상품에 연결된 이미지 파일 정보 |
| Order          | 사용자 주문 정보              |

---

## 🔗 테이블 간 관계

- **User 1:N Order**
- **Product 1:N Order**
- **Product 1:N ImageFile**

---

## 🧾 테이블 정의

### 🔹 User

| 컬럼명       | 타입       | 설명               |
|--------------|------------|--------------------|
| id           | Long       | 기본 키 (PK)        |
| username     | String     | 사용자 아이디       |
| password     | String     | 비밀번호           |
| role         | String     | 사용자 권한 (ADMIN/USER) |
| created_at   | LocalDateTime | 생성일자           |

---

### 🔹 Product

| 컬럼명         | 타입    | 설명           |
|----------------|---------|----------------|
| id             | Long    | 기본 키 (PK)    |
| name           | String  | 상품 이름       |
| description    | String  | 상품 설명       |
| price          | Integer | 가격           |
| stock_quantity | Integer | 재고 수량       |

---

### 🔹 ImageFile

| 컬럼명      | 타입    | 설명                        |
|-------------|---------|-----------------------------|
| id          | Long    | 기본 키 (PK)                 |
| product_id  | Long    | 연관 상품 ID (FK)            |
| filename    | String  | 저장된 파일명                |
| url         | String  | S3에 저장된 URL             |
| uploaded_at | LocalDateTime | 업로드 시각           |

---

### 🔹 Order

| 컬럼명     | 타입    | 설명                        |
|------------|---------|-----------------------------|
| id         | Long    | 기본 키 (PK)                 |
| user_id    | Long    | 주문한 사용자 ID (FK)        |
| product_id | Long    | 주문한 상품 ID (FK)          |
| quantity   | Integer | 주문 수량                    |
| ordered_at | LocalDateTime | 주문 시간             |

---

## 📌 참고

- 모든 테이블의 `id`는 `@Id`, `@GeneratedValue` 사용 예정
- 시간 관련 필드는 `LocalDateTime` 사용
- 연관관계는 `@ManyToOne`, `@OneToMany` 로 매핑 예정