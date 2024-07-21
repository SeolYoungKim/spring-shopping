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
  - [x] 이메일 중복 확인 시, 동시성 이슈를 고려해야 한다 
  - [x] 비밀번호는 암호화해서 저장한다
- [x] 이메일, 비밀번호를 보내고 가입한 이메일과 비밀번호가 일치할 경우 토큰이 발급된다
  - 토큰은 JWT를 사용할건데, 이유는 한번 생각해보자.
    - JWT는 JSON 기반의 웹 토큰으로, 주로 인증과 권한 부여를 위해 사용됩니다. JWT를 사용하는 주된 이유는 다음과 같습니다:
      1. 무상태성: 서버는 클라이언트의 상태를 유지할 필요가 없습니다. JWT는 클라이언트가 자체적으로 토큰을 가지고 다니면서 인증 정보를 유지합니다.
      2. 확장성: 서버가 사용자 상태를 유지하지 않기 때문에, 서버의 확장성이 높아집니다. 여러 서버 간의 세션 공유 문제가 발생하지 않습니다.
      3. 보안성: JWT는 서명되어 있어 변경될 수 없습니다. 이를 통해 데이터의 무결성을 보장합니다. 또한, 암호화를 통해 토큰 내용을 보호할 수도 있습니다.
      4. 다양한 환경에서 사용 가능: JWT는 모바일, 웹 등 다양한 클라이언트와 서버 환경에서 사용 가능합니다.
      5. 표준화: JWT는 RFC 7519에 정의된 표준을 따르므로, 다양한 라이브러리와 도구에서 지원됩니다.
  - 토큰 발급 및 응답
  - 토큰 사용 시 : 토큰 resolve(ArgumentResolver) -> 인증 객체 생성 
  - Key 암호화 방안 필요

### 위시 리스트
- [x] 토큰을 이용한다
  - Filter or ArgumentResolver 를 활용해서 수행해보자
- [x] 위시 리스트에 상품을 추가할 수 있다
- [x] 위시 리스트에 등록된 상품 목록을 조회한다
- [x] 위시 리스트에 담긴 상품을 삭제할 수 있다 

#### 추가 구현 
- [x] 중복 등록 제한하기 

### 테스트 코드 작성 
- [] 구현한 API들에 대해 인수테스트 작성 