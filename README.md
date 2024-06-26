## 🚀 기능 요구 사항

### 개발 환경
1. 인텔리제이 IDEA
2. MySQL 8.x.xx
3. JDK 17

---

### DB
- database 이름: testdb
- 주어진 SQL파일 사용해 테이블 생성
    - 다른 SQL사용시 별도 제출
    - insert문은 알아서 작성
- 페이지 시연에 필요한 데이터 삽입 필수

---

## 사용자 페이지

### 회원가입 페이지 ✅
- 유효성 확인 후 사용자 알림은 JS Alert창 또는 HTML안에 내용(innertText, innerHTML)으로 입력 ✅
1. 모든 입력란 입력 필수 ✅
    - 입력하지 않고 제출했을 경우, 사용자 알림 띄우기
2. 아이디 중복 확인 필수 ✅
    - ajax통신으로 DB접근 -> 결과 사용자 알림 띄우기( “아이디 사용가능합니다” 또는 “아이디가 중복됩니다” )
3. 비밀번호는 4자리 이상 ✅
    - 유효성 체크는 js 안에서
    - 유효성 체크에 걸릴 경우, 사용자 알림("4자리이상만 가능합니다.") -> 서버에  submit이 되지 않도록 주의
4. 비밀번호와 비밀번호 확인 값이 확인 필수 ✅
    - 유효성 체크는 js 안에서
    - 버튼 클릭시 사용자 알림 띄우기(암호가 일치하지 않습니다. 다시 입력해주세요”)
5. 위의 조건을 모두 만족하면, DB에 사용자 저장 ✅

### 로그인 페이지
- 유효성 확인 후 사용자 알림은 JS Alert창 또는 HTML안에 내용(innertText, innerHTML)으로 입력 ✅
1. 입력한 아이디가 존재하지 않으면 사용자 알림(“아이디가 존재하지 않습니다.”) ✅
2. 비밀번호가 틀리다면 사용자 알림(“비밀번호가 다릅니다.”) ✅
3. 모두 일치하면 사용자 알림(“로그인되었습니다.”) 후 홈화면 이동
4. 로그인 정보 세션 저장 ✅
    - 로그인한 사용자만 고객지원 - 1:1문의, 묻고답하기, FAQ화면에 접근하도록 허용 ✅
    - 로그인을 안한 사용자가 접근시 사용자 알림(“로그인을 해주세요”) 후 로그인 화면으로 이동 ✅

### 아이디 찾기 / 비밀번호 찾기 ✅
1. 입력된 정보로 DB검색 후 화면 출력
* 원래 화면과 통신 없음
* 팝업이 아닌 본문 페이지 이동으로 구현해도 됨

### 공지사항
1. 화면 진입시, DB에 있는 공지 리스트 출력 ✅
2. 제목, 내용 중 하나를 선택하고 검색어를 입력하면 검색 목록이 출력됨 ✅
    - 검색어를 "포함하는" 모든 공지 출력
3. 공지 목록에서 번호/타이틀/작성일을 클릭하면 공지사항 상세 페이지로 이동 ✅
    ex) http://localhost:8080/community/community01_1?notice_idx=5
4. 공지사항 상세 페이지는 제목, 작성일, 내용 포함 필수 ✅


### 1:1문의
1. "구분", "우편번호" 데이터 제외 나머지 데이터 DB 저장 ✅
    - 주소는 주소+상세주소로 합쳐서 하나로 저장

### 묻고 답하기
1. 페이지 진입시 DB에 있는 묻고 답하기 글 리스트 출력 ✅
2. 제목, 내용, 작성자 중 하나를 선택하고 검색을 누르면 해당 목록 출력 ✅
    - SQL LIKE구문 이용 -> 해당 검색어가 들어가는 조건
3. 목록에서 번호/제목/작성자/작성일을 누르면 비번입력창으로 이동 ✅
4. 비밀번호입력 창에서 글작성시 입력한 비번을 입력할때만 상세화면으로 이동
5. 상세 화면에서 상세 정보 출력 ✅

<br><br>

## 관리자 페이지
1. 별도 링크 없음.  http://localhost:8080/admin 으로 접근 ✅
2. admin/1234가 맞는지 확인 ✅
    - 하드코딩 하지 말고 db검색으로 확인 ✅

### 회원 관리
1. 페이지 진입시 DB에 있는 회원 목록 출력 (아이디/성명/이메일/생일/가입일) ✅
2. 전체/아이디/성명/이메일/주소 검색옵션과 검색어로 검색 기능 구현 ✅
    - 전체: 아이디, 성명, 이메일, 주소 중에서 검색어를 포함하고 있으면 목록에 출력
        * 영어 대소문자 구분X
    - 아이디/성명/이메일/주소는 검색어를 포함하고 있으면 목록에 출력
3. 아이디 오름차순/내림차순, 가입일 오름차순/내림차순 정렬 기능 구현 ✅
    - select 태그의 onchange이벤트 사용
4. 5개 또는 10개 선택에 따라 표시 수 조절 ✅
    - select 태그의 onchange이벤트 사용

### 공지사항 관리
1. 페이지 진입시 DB에 있는 공지사항 목록 출력 (글번호/제목/글쓴이/작성일) ✅
2. 전체/제목/내용/작성자아이디 검색옵션과 검색어로 검색 기능 구현 ✅
    - 전체: 제목, 내용, 작성자 아이디 중에서 검색어를 포함하고 있으면 목록에 출력
        * 영어 대소문자 구분X
    - 제목/내용/작성자아이디는 검색어를 포함하고 있으면 목록에 출력
3. 아이디 오름차순/내림차순, 가입일 오름차순/내림차순 정렬 기능 구현 ✅
    - select 태그의 onchange이벤트 사용
4. 5개 또는 10개 또는 전체 선택에 따라 표시 수 조절 ✅
    - select 태그의 onchange이벤트 사용
5. 네비게이션 구현X ✅
6. 공지 글쓰기 누르면 공지사항 작성 페이지로 이동 ✅
7. 글번호/제목/글쓴이/작성일 중 하나를 클릭하면 공지사항 수정 화면으로 이동 ✅

### 공지사항 작성
* 일반공지, 중요공지 옵션은 무시 ✅
1. 제목, 내용, 작성일, 작성자 아이디 DB 저장 ✅
2. ckeditor4를 제거하고 input태그 type=”text”로 구현 또는 textarea태그 내용으로 form태그를 사용하여 구현 ✅

### 공지사항 수정
1. 내용만 수정하여 수정버튼을 클릭시 DB 내용 수정 ✅
2. ckeditor4를 제거하고 input태그 type=”text”로 구현 또는 textarea태그 내용으로 form태그를 사용하여 구현 ✅
