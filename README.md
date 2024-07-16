# spring-shopping-product
## 기능 요구사항
### 상품 API
> #### 공통 조건 
> - 요청 및 응답은 JSON 형식으로 주고 받는다

#### 상품을 조회, 추가, 수정, 삭제할 수 있다
- [x] 상품을 추가한다
  - 상품 이미지의 경우, 파일을 업로드 하지 않고 URL을 직접 입력한다
- [x] 상품을 조회한다 
- [x] 상품 목록을 조회한다 
  - 페이징이 필요할 것 같다. 
- [x] 상품을 수정한다 
- [x] 상품을 삭제한다 

 
#### 유효성 검사 및 예외 처리  
- [x] 어떤 부분이 왜 잘못되었는지 인지할 수 있는 응답을 제공한다 
- [x] 상품 이름은 공백 포함 최대 15자 까지 입력 가능하다 
- [x] 특수 문자는 `( ) [ ] + - & / _`만 가능하며, 그 외는 불가능하다 
- [x] 상품 이름에 비속어를 포함하지 않는다  
  - https://www.purgomalum.com/ 

### 회원 로그인 
- [x] 이메일, 비밀번호를 입력하여 회원가입을 할 수 있다 
  - [x] 이메일은 중복될 수 없다
  - [] 이메일 중복 확인 시, 동시성 이슈를 고려해야 한다 
  - [] 비밀번호는 암호화해서 저장한다 
- [] 이메일, 비밀번호를 보내고 가입한 이메일과 비밀번호가 일치할 경우 토큰이 발급된다 

### 위시 리스트
- [] 토큰을 이용한다
- [] 위시 리스트에 등록된 상품 목록을 조회한다
- [] 위시 리스트에 상품을 추가할 수 있다 
- [] 위시 리스트에 담긴 상품을 삭제할 수 있다 