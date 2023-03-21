# 🧑🏻‍🍳 Share My Recipe!

> 나만의 레시피를 공유해봐요! 🥗

<br>

**💡 프로젝트에 대한 더 자세한 내용은 첨부한 Notion에 있습니다.**

## 📌 목차
1. [개요](#-개요)
2. [사용 언어 및 개발 환경](#-사용-언어-및-개발-환경)
3. [프로젝트 목적](#-프로젝트-목적)
4. [후기](#-후기)
5. [DB 구조](#-db-구조)
6. [구현 기능](#-구현-기능)
7. [주요 진행 상황](#-주요-진행-상황)
8. [학습 내용 & 개선된 내용](#-학습-내용--개선된-내용)
9. [후기 & 앞으로 개선할 내용](#-후기--앞으로-개선할-내용)

<br>

## ✔ 개요
* 개발 기간
  * 2023.01.01 ~
* 개발 인원
  * 개인 프로젝트

<br>

## ✔ 사용 언어 및 개발 환경
- Java 11
- Spring Boot 2.7
- Maven
- Spring Data JPA
- MySQL
- Thymeleaf
- IntelliJ

<br>

## ✔ 프로젝트 목적
```text
💡 SpringBoot와 JPA를 이용한 개인 프로젝트 입니다.

이번 프로젝트의 목표는
- 프로젝트 목적 변경하기 (View 중심의 프로젝트 → 코드에 집중한 프로젝트)
- 학습한 JPA 적용하기
- Exception과 Custom Exception 처리 적용하기
- DTO 구조 적용하기
- Test Code 작성하기
  
입니다.

또한 같은 결과를 위해 다른 기술들을 적용해보는 것입니다.

2022년 교육을 받으며 처음 Spring Framework를 접하게 되었습니다.
"게시판 만들기"를 통해
웹 애플리케이션의 동작 흐름을 학습하고자 프로젝트를 제작하였습니다.
```

<br>

## ❗ 후기
```text
그전 프로젝트까진 적용해보지 않았던 것들을 적용해보았습니다.

따라서 개발 환경에 많은 변화가 있었습니다.

특히 같은 기능을 다른 기술들로 적용해보는 과정은 매우 흥미로웠습니다.

또한 '개인'으로 진행했던 경험은 '팀'으로 진행했을 때는 느낄 수 없었던 것을 알게 되었습니다.
팀 프로젝트를 했을 시엔, 다른 팀원의 실력을 곧 내 실력으로 착각했다는 것을 
이번 개인 프로젝트를 경험하며 깨닫게 되었습니다.
따라서 제가 당연히 알고 있다고 생각했던 '기본'에 관련된 것들에 부족함을 느껴 
하나씩 채우게 되는 의미 있는 프로젝트가 되었습니다.

이번 개인 프로젝트를 계기로 
'기본'이란 쉬운 것이 아닌 '중요한 것'임을 알게 되었습니다.
때문에 어려울수록 기본에 충실해야 한다는 것을 명심했습니다.
```

<br>

## ✔ DB 구조
![](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2e01ba2b-44c9-43c4-bfc1-e222e07909fd/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230321%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230321T033932Z&X-Amz-Expires=86400&X-Amz-Signature=b9a6ac179829dd8b90a615c9c431120b23b9a9e36c78d9a4082c52cab83d3f4b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

<br>

## ✔ 구현 기능
1. Spring-Security를 활용한 회원가입 
   1. 비밀번호 암호화 저장 
   2. 중복 아이디 회원가입 불가능


2. 레시피(게시물) 등록 
   1. 조회수 측정
   2. 등록 / 삭제 / 조회 / 수정(ADMIN 권한이 없을 시 비활성)
   3. 게시글 등록자만 수정 가능
   4. 회원이 아닐 시 게시글 등록 불가


3. 게시글 이미지 등록


4. 게시글 저장
   1. 회원이 아닐 시 게시글 저장 불가
   2. 게시글 중복 저장 불가능


5. 게시글 댓글

<br>
<br>

## 📝 주요 진행 상황
0. RESTful API 적용
    - [모든 API를 POST로 보냈던 과거에서, GET, POST, PUT, DELETE로 목적에 맞게 나누기](https://ummmmchicken.tistory.com/entry/JPA-1-N-%EA%B4%80%EA%B3%84%EB%A5%BC-%EB%B6%84%EC%84%9D%ED%95%B4%EB%B3%B4%EC%9E%90)
1. MyBatis → JPA
    - [SQL Mapper인 MyBatis와 Java ORM인 JPA의 차이를 체감](https://ummmmchicken.tistory.com/entry/JPA-MyBatis%EC%99%80-JPA-%EB%8F%84%EB%8C%80%EC%B2%B4-%EB%AD%90%EA%B0%80-%EB%8B%A4%EB%A5%BC%EA%B9%8C)
    - [1 : N 관계의 영속성 전이 구현](https://ummmmchicken.tistory.com/entry/JPA-1-N-%EA%B4%80%EA%B3%84%EB%A5%BC-%EB%B6%84%EC%84%9D%ED%95%B4%EB%B3%B4%EC%9E%90)
2. Spring Security 적용
    - [Spring Security를 사용하기 위한 분석](https://ummmmchicken.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0%EB%A5%BC-%EB%B6%84%EC%84%9D%ED%95%B4%EB%B3%B4%EC%9E%90)
    - [단순 DB insert에서, Spring Security를 이용해 권한을 부여하는 구현기](https://ummmmchicken.tistory.com/entry/Spring-Security%EB%A1%9C-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%EC%9D%84-%ED%95%B4%EB%B3%B4%EC%9E%90-1)
3. Custom Exception 적용
    - [엔티티 별 예외 발생 상황을 한 곳에 모아 처리하기](https://ummmmchicken.tistory.com/entry/Custom-Exception-%ED%95%B4%EB%B3%B4%EA%B8%B0)
    - [Ajax로 일일이 체크했던 과거에서, Spring BindingResult와 Validation을 이용한 유효성 검증 구현기](https://ummmmchicken.tistory.com/entry/%EC%97%90%EB%9F%AC-%ED%9A%8C%EC%9B%90-%EA%B0%80%EC%9E%85-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%97%90%EB%9F%AC-%EC%B2%98%EB%A6%AC%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EC%B0%B0)
4. DTO 적용
    - [DTO는 왜 만드는 것일까?에 대한 고찰](https://ummmmchicken.tistory.com/entry/%EC%83%9D%EA%B0%81%EB%93%A4-%EB%8F%84%EB%8C%80%EC%B2%B4-DTO%EB%A5%BC-%EC%99%9C-%EB%A7%8C%EB%93%9C%EB%8A%94-%EA%B2%83%EC%9D%B8%EA%B0%80%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EC%B0%B0)
    - [Entity 외부 노출에 대비해, 용도에 따른 EntityDTO 4개로 나누는 구현기](https://ummmmchicken.tistory.com/entry/CRUD%EB%A5%BC-%EB%B6%84%EC%84%9D%ED%95%B4%EB%B3%B4%EC%9E%90-1-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EC%83%9D%EC%84%B1-API)
5. Test Code 작성
    - Test Code를 통해 View가 없어도 구현 기능이 정상 작동 되는지 테스트 가능
    - [Mock Test로 Security 권한 테스트 구현기](https://ummmmchicken.tistory.com/entry/Spring-Security%EB%A1%9C-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%EC%9D%84-%ED%95%B4%EB%B3%B4%EC%9E%90-3-SecurityConfig-%EB%B0%8F-%EB%A1%9C%EA%B7%B8%EC%9D%B8)


<br>
<br>


## ✏ 학습 내용 & 개선된 내용
### 0. 프로젝트 목적 변경
> View Page에만 집중 → 코드에 집중
<details>
<summary>[이전 상황] 보여지는 View Page에만 집중</summary>
<div markdown="1">

```
국비교육을 받으며 팀 & 개인 프로젝트를 했을 시엔 보여지는 View Page에만 집중했습니다.

따라서 코드가 어떻게 됐든, 
보여지는 화면(View)만 원하는 결과가 나오게끔 코드를 작성했습니다.
그 결과 
어떤 기능을 구현하면, 다른 기능에 문제가 생기고 
그 문제를 해결하면, 또다른 문제가 생기는 상황이 반복됐습니다.

근본적인 문제를 해결하지 못하고 문제 상황을 막기에만 급했습니다.
결과적으론, 매우 지저분하고 알 수 없는 
즉, 유지보수가 매우 어려운 코드가 최종 결과물이 되었습니다.

그때에는 그 방식이 맞는 방식인 줄 알았습니다.

하지만 UI에 신경쓰는 것이 아닌 기능 구현 코드에 집중해야한다는 사실을 알게되었고, 
이번 프로젝트부턴 코드에 집중하는 것으로 목적을 변경했습니다.
```
</div>
</details>

<details>
<summary>[이번 프로젝트 시] 기능 구현 코드에 집중</summary>
<div markdown="1">

```
제일 큰 변화는 여태껏 배워왔고 적용시켰던 MyBatis가 아닌, 
새롭게 학습한 JPA를 이용하는 것이었습니다.

또한 Test Code도 프로젝트에 적용시켜보았습니다.
그에 따라 예외 상황들에 대한 코드들도 생각해보게 되었습니다.
```
</div>
</details>

<br>

### 1. JPA 적용하기
> MyBatis를 사용했던 지난 프로젝트 → JPA 적용하기

```text
🤔 MyBatis를 배울 땐, 당연히 그 기술만 쓰는 것인 줄 알았습니다.

시작할 땐 JPA의 개념이 MyBatis처럼 SQL 쿼리에 객체를 Mapping만 하는 
단순 작업인 줄 알았습니다.

Why? 왜 JPA를 사용했을까?
1. 객체 설계 중심으로 생산성을 높일 수 있습니다.
2. 필드를 변경해도 수정해야 할 코드가 줄어들어 유지보수가 편리합니다.
3. JPA는 연관관계와 관련된 패러다임의 불일치를 해결해줍니다.
4. 애플리케이션과 데이터베이스 사이에서 다양한 성능 최적화 기회를 제공합니다.
등등 

하지만 학습하다보니,
💡 'JPA는 Java의 OOP의 개념을 제대로 알고 활용할 줄 알아야 하는 등
제대로 익히기가 매우 까다롭고 어렵다'는 사실을 알게 되었습니다.
```

<details>
<summary>[이전 상황] MyBais를 이용해 구현했던 회원정보 저장 & 회원정보 수정</summary>
<div markdown="1">

<details>
<summary>Ex 1) 회원정보 저장</summary>
<div markdown="1">

* SQL Mapper
```xml
<!-- 회원 가입 -->
<insert id="insertMember" parameterType="com.jobdongsan.project.model.MemberVO">
	INSERT INTO member (memId, memPw, memName, memEmail, memChildBirth, memHP, memZipcode, memAddress1, memAddress2)
	VALUES (#{memId}, #{memPw}, #{memName}, #{memEmail}, #{memChildBirth}, #{memHP}, #{memZipcode}, #{memAddress1}, #{memAddress2})
</insert>

<!-- Oauth 회원 가입  -->
<insert id="insertOauthMember" parameterType="com.jobdongsan.project.model.MemberVO">
	INSERT INTO member (memId, memPw, memName, memEmail, profileImg, provider, providerId)
	VALUES (#{memId}, #{memPw}, #{memName}, #{memEmail}, #{profileImg}, #{provider}, #{providerId})
</insert>
```

* MemberDAO Interface
```java
public void insertMember(MemberVO vo); // 회원 가입
public void insertOauthMember(MemberVO vo); // SNS 회원 가입
```

* MemberService
```java
// 회원 가입
@Override
public void insertMember(MemberVO vo) {
	// 비밀번호 암호화 처리한 후 mapper에게 전달
	String encodedPwd = pwdEncoder.encode(vo.getMemPw());
	vo.setMemPw(encodedPwd);
	
	dao.insertMember(vo); // 회원정보 저장(INSERT) SQL Mapper
}

// SNS 회원 가입
@Override
public void insertOauthMember(MemberVO vo) {
	dao.insertOauthMember(vo);
}
```

</div>
</details>

<details>
<summary>Ex 2) 회원정보 수정</summary>
<div markdown="1">

* SQL Mapper
```xml
<!-- 회원 정보 수정 -->
<update id="updateMemberInfo" parameterType="com.jobdongsan.project.model.MemberVO">
	UPDATE member SET memPw = #{memPw}, memName = #{memName}, memEmail = #{memEmail},
	memChildBirth = #{memChildBirth}, memHP = #{memHP}, memZipcode = #{memZipcode}, memAddress1 = #{memAddress1},
	memAddress2 = #{memAddress2}, profileImg = #{profileImg} WHERE memId = #{memId}
</update>
```

* MemberDAO Interface
```java
public void updateMemberInfo(MemberVO vo); // 회원 정보 수정
```

* MemberService
```java
@Override
public void updateMemberInfo(MemberVO vo) {
	String encodedPwd = pwdEncoder.encode(vo.getMemPw());
	vo.setMemPw(encodedPwd);
	
	dao.updateMemberInfo(vo);
}
```

</div>
</details>

</div>
</details>

<details>
<summary>[이번 프로젝트 시] JPA를 이용해 구현한 회원정보 저장 & 회원정보 수정</summary>
<div markdown="1">

<details>
<summary>Ex 1) 회원정보 저장</summary>
<div markdown="1">

* MemberRepository
```java
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이메일로 중복 검사
    Member findByEmail(String email);
}
```

* MemberService
```java
public Member saveMember(Member member) {
    validateDuplicateMember(member); // 회원가입 중복 검사
    return memberRepository.save(member); // 회원 정보 저장
}

/**
 * 회원가입 중복 검사
 * 이메일 중복 불가능
 * */
private void validateDuplicateMember(Member member) {
    Member findMember = memberRepository.findByEmail(member.getEmail()); // 이메일로 찾은 회원을 Member에 담는다.
    if(findMember != null) {
        // 예외처리
        throw new AppException(ErrorCode.MEMBERNAME_DUPLICATED, findMember.getName() + "은 이미 있습니다.");
    }
}
```

</div>
</details>

<details>
<summary>Ex 2) 회원정보 수정 : 원하는 정보만 선택해 수정</summary>
<div markdown="1">

* Member Entity
```java
public void updateMember(MemberFormDto memberFormDto, String password) {
    this.name = memberFormDto.getName();
    this.password = password;
    this.address = memberFormDto.getAddress();
}
```

* MemberService
```java
public Long updateMember(Long memberId, MemberFormDto memberFormDto) {

    Member findMember = memberRepository.findById(memberId)
            .orElseThrow(EntityNotFoundException::new);

    String password = passwordEncoder.encode(findMember.getPassword());

    findMember.updateMember(memberFormDto, password);

    return findMember.getId();
}
```

</div>
</details>

</div>
</details>

<details>
<summary>느낀점</summary>
<div markdown="1">

- JPA 덕분에 SQL에 의존적인 코드를 짜지 않고, Java 중심의 코드를 짤 수 있었다.
- SQL Mapper로 구현했을 때처럼 자주 쓰는 CRUD 메소드를 직접 다 작성하지 않아도 돼 코드의 양이 줄었다.
- JPA는 기본적인 CRUD를 제공해 비즈니스 로직에 보다 더 집중할 수 있다.
- 검색 기능에 한해 아직까지는 Querydsl보다 myBatis가 직관적이어서 그런지 더 이해가 쉽다.
- Querydsl의 더 깊은 이해와 학습이 필요하다.

</div>
</details>

<br>

### 2. Exception과 Custom Exception 적용하기
> 예외 처리를 전혀 하지 않았던 지난 프로젝트 → 예외 처리 적용

```text
🤔 회원 가입과 로그인 기능은 간단한 줄 알았습니다.

하지만 회원 가입과 로그인 뿐 아니라 서비스를 이용하는 모든 과정에선, 
여러가지 상황들과 오류들이 발생할 수 있다는 것을 알게 되었습니다.
따라서 발생할 수 있는 여러 예외 상황들에 대한 것들을 고민해보게 되었습니다.

Why? 왜 Custom Exception을 써야만 할까?
1. 예외 메시지로도 충분히 의미를 전달할 수 있습니다.
2. 상세한 예외 정보를 제공할 수 있습니다.
3. 예외에 대한 것들을 한 곳에 관리할 수 있습니다.
등등 

💡 그 과정에선 '예외 처리를 하는 방법은 여러가지'이고, 
'예외 처리를 custom하여 처리할 수 있다는 것'도 알게 되었습니다.
```

<details>
<summary>[이전 상황] 예외 처리를 전혀 하지 않았던 지난 프로젝트들</summary>
<div markdown="1">

* Ex) 마이페이지에 게시물 저장 시, 중복 저장 처리
```java
// 마이페이지 게시물 저장
@ResponseBody
@RequestMapping("/insert_video")
public String insertVideo(@RequestParam HashMap<String, Object> param, HttpSession session) {
	String result = null;
	String memId = (String)session.getAttribute("sid");
	
	param.put("memId", memId);

	// 저장하려는 게시물이 마이페이지에 있는지 갯수를 체크한다.
	int count = videoService.checkVideo(Integer.parseInt((String)param.get("videoNo")), memId);
	if(count == 0) { // 만약 게시물이 없다면 (마이페이지 게시물 0개)
		videoService.insertVideo(param);
		result = "0";
	}
	else { // 만약 게시물이 있다면, 의미없는 숫자(result = 1) 반환
		result = "1";
	}
	
	return result;
}
```

* SQL Mapper : 마이페이지에 동일 게시물이 존재하는지 확인
```xml
<!-- 마이페이지에 동일 게시물이 존재하는지 확인 -->
<!-- 회원의 마이페이지에 저장하고자 하는 게시물의 개수 카운트 -->
<select id="checkVideo" parameterType="hashmap" resultType="int">
	SELECT COUNT(*)
	FROM my_history 
	WHERE videoNo=#{videoNo} AND memId=#{memId} 
</select>
```

</div>
</details>

<details>
<summary>[이번 프로젝트 시] 예외 처리를 적용해보았던 이번 프로젝트</summary>
<div markdown="1">

<details>
<summary>Ex 1) 회원 가입 중복 검사</summary>
<div markdown="1">

* 단계 1 : throw new IllegalStateException
```java
private void validateDuplicateMember(Member member) {
    Member findMember = memberRepository.findByEmail(member.getEmail()); // 이메일로 찾은 회원을 Member에 담는다.
    if(findMember != null) { // 회원 정보가 존재하면
        // IllegalStateException 예외처리
        throw new IllegalStateException("이미 가입된 회원입니다.");
    }
}
```

* 단계 2 : custom한 AppException으로 처리
```java
private void validateDuplicateMember(Member member) {
    Member findMember = memberRepository.findByEmail(member.getEmail()); // 이메일로 찾은 회원을 Member에 담는다.
    if(findMember != null) { // 회원 정보가 존재하면
        // AppException 예외처리
        // MEMBERNAME_DUPLICATED(HttpStatus.CONFLICT, "")
        throw new AppException(ErrorCode.MEMBERNAME_DUPLICATED, findMember.getName() + "은 이미 있습니다.");
    }
}
```

* 단계 3 : RuntimeException을 상속받는 BaseException 생성
```java
public interface BaseExceptionType {

    // 에러 코드
    int getErrorCode();

    // Http 상태
    HttpStatus getHttpStatus();

    // 에러 메세지
    String getErrorMessage();

}
```
```java
public enum MemberExceptionType implements BaseExceptionType {

    // 회원가입, 로그인시
    ALREADY_EXIST_USERNAME(600, HttpStatus.CONFLICT, "이미 존재하는 아이디입니다."),
    NOT_FOUND_MEMBER(602, HttpStatus.NOT_FOUND, "회원 정보가 없습니다.");

    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    MemberExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
```

</div>
</details>

<details>
<summary>Ex 2) 마이페이지에 게시물 저장 시, 중복 저장 처리</summary>
<div markdown="1">

* CartController : 마이페이지 컨트롤러
```java
try {
    cartRecipeId = cartService.addCart(cartRecipeDto, email);
} catch (AppException e) { // 만들어놓은 AppException으로 예외처리를 한다.
    model.addAttribute("errorMessage", e.getMessage()); // 예외처리 메세지를 마이페이지 view에 전달
    return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
}
```

* CartService
```java
CartRecipe savedCartRecipe = cartRecipeRepository.findByCartIdAndRecipeId(cart.getId(), recipe.getId());

// 레시피 중복 저장
if(savedCartRecipe != null) { // 마이페이지에 게시물이 저장되어 있다면
    // AppException의 CART_RECIPE_DUPLICATED로 예외처리를 한다.
    throw new AppException(ErrorCode.CART_RECIPE_DUPLICATED, recipe.getRecipeName() + "은 이미 저장되어있습니다.");
}

CartRecipe cartRecipe = CartRecipe.createCartRecipe(cart, recipe);
cartRecipeRepository.save(cartRecipe);
```

</div>
</details>

</div>
</details>

<details>
<summary>느낀점</summary>
<div markdown="1">

- Custom Exception의 Test Code 실패로 다시 원래 코드로 돌아간 것들이 있어 아쉽다.
- 오류 없이 예외 처리를 할 수 있는 방법을 배우고 싶다.
- 내가 구현한 Custom Exception이 맞는 방식인지 모르겠다. 제대로 배우고 싶다.

</div>
</details>

<br>

### 3. DTO 적용하기
> DTO의 존재를 몰라 Entity를 그대로 반환 → DTO 적용

```text
🤔 엔티티를 직접 반환했던 이전 프로젝트들과 달리, 
별도의 DTO를 만들어 반환하였습니다.

Why? 왜 DTO를 써야만 할까?
1. 테이블 설계를 노출하지 않고, 엔티티 내부 구현을 캡슐화 할 수 있습니다.
2. View에 필요한 데이터를 선별할 수 있습니다.
3. 순환참조가 일어나지 않도록 응답 DTO를 두는 것이 안전합니다.
4. 각 요청에 필요한 validation을 DTO에 정의하면, 엔티티를 모델링과 비즈니스 로직에 집중되도록 만들 수 있습니다.
등등

실무를 경험해본 적이 없어 와닿지 않는 부분이었습니다.
하지만 성능 문제를 야기할 수 있는 것들에 대해 공부해보았고, 
💡 그 중 '엔티티를 웹에 노출해서는 안 된다는 것'을 알게 되었습니다.
```

<details>
<summary>[이전 상황] DTO의 존재를 몰랐던 지난 프로젝트들</summary>
<div markdown="1">

* Ex) 모든 게시물 출력
* [Controller] : DTO를 생성하지 않고, Entity를 바로 반환했다.
```java
// 전체 게시물 출력
@RequestMapping("/job_index")
public String viewJobAllList(Model model) {

  // 게시물 Entity를 그대로 Serivce에 전달한다.
  ArrayList<JobVO> jobList = jobService.listAllJob();
  model.addAttribute("jobList", jobList); // View Page에 Entity를 바로 전달한다.

  return "job/job_index";
}
```
</div>
</details>

<details>
<summary>[이번 프로젝트 시] DTO가 왜 적용되어야 하는지 학습하고 적용</summary>
<div markdown="1">

* ‘DTO를 왜 만드는 것인가'에 대한 고찰
* Ex) 모든 게시물 출력
* [MainItemDto]
```java
@Setter
@Getter
public class MainItemDto {

    private Long id;
    private String recipeName;
    private String recipeDetail;
    private String imgUrl;
    private Integer price;

   /**
   * @QueryProjection : Querydsl로 결과 조회 시, MainItemDto 객체로 바로 받아옴
   * - DTO 클래스로 변환하는 과정 없이 바로 DTO 객체를 뽑아냄
   * - DTO 기반으로 생성된 QDTO 객체의 생성자를 사용하는 것
   * */
    @QueryProjection
    public MainItemDto(Long id, String recipeName, String recipeDetail, String imgUrl, Integer price) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeDetail = recipeDetail;
        this.imgUrl = imgUrl;
        this.price = price;
    }
}
```

* MainController
```java
@GetMapping(value = "/")
public String main(RecipeSearchDto recipeSearchDto, Optional<Integer> page, Model model){

    Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);

    // 출력할 게시물 DTO를 Service에 전달한다.
    Page<MainItemDto> recipes = recipeService.getMainRecipePage(recipeSearchDto, pageable);

    model.addAttribute("recipes", recipes);
    model.addAttribute("recipeSearchDto", recipeSearchDto);
    model.addAttribute("maxPage", 5);

    return "main";
}
```

</div>
</details>

<details>
<summary>느낀점</summary>
<div markdown="1">

- DTO가 없을수록 구조가 단순하고 직관적이어서 이해가 쉬웠다.
- 하지만 DTO가 많아질수록 구조가 복잡해지고 DTO와 Entity 사이의 변환, DTO와 Service의 교류 등이 이해하기 어려워졌다.
- 따라서 RequestDTO와 ResponseDTO로 더 세분화해서 나누려면, DTO의 더 깊은 이해가 필요하다.
- 객체 지향 설계 역시 더 제대로 된 이해와 적용이 필요하다.

</div>
</details>

<br>

### 4. Test Code 작성하기
> 매번 View Page를 통해 의도한 결과가 맞는지 확인 → Test Code 적용

```text
🤔 이전 프로젝트들에선 
Test Code를 작성하지 않고, 작성한 코드가 정상적으로 돌아가는지 
매번 View Page에서 확인을 했었습니다.

하지만 Test Code를 작성하면, 코드의 추가 또는 변경이 있을 경우 
문제를 빠르게 파악하여 개발의 유지보수성을 증진시킬 수 있다는 것을 알게되었습니다.

Why? 왜 테스트 코드를 작성해야 할까?
1. 단위 테스트는 개발 초기에 문제를 발견하게 도와줍니다.
2. 단위 테스트로 인해 코드를 리팩토링할 시 기존 기능이 올바르게 작동하는지 확인할 수 있습니다.
3. 단위 테스트는 기능에 대한 불확실성을 감소시킬 수 있습니다.
4. 단위 테스트 자체가 시스템 문서로 사용될 수 있습니다.
등등

따라서 이번 프로젝트를 통해 
💡 'Test Code를 작성했고, 후에 View Page 코드를 완성'했습니다.
```

<details>
<summary>[이전 상황] Test Code의 존재 자체를 몰랐던 지난 프로젝트들</summary>
<div markdown="1">

* Ex) Test View Page를 생성해 의도한 결과가 맞게 나오는지 확인
* [test.jsp]
```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="width: 800px; height: 500px; background-color :red; display:flex; flex-direction:row;">
<div style="width: 50px; height:30px; margin:30px; background-color: blue;"></div>
<div style="width: 50px; height:30px;margin:30px; background-color: blue;"></div>
<div style="width: 50px; height:30px;margin:30px; background-color: blue;"></div>
<div style="width: 50px; height:30px;margin:30px; background-color: blue;"></div>
</div>

<script>


</script>
```
</div>
</details>

<details>
<summary>[이번 프로젝트 시] 코드에 좀 더 집중하기 위해 Test Code를 적용</summary>
<div markdown="1">

* Ex 1) 중복 회원 가입 테스트
```java
// 임의의 회원 정보 생성
public Member createMember() {
    MemberFormDto memberFormDto = new MemberFormDto();
    memberFormDto.setEmail("test@email.com");
    memberFormDto.setName("김길동");
    memberFormDto.setAddress("경기도");
    memberFormDto.setPassword("1234");
    return Member.createMember(memberFormDto, passwordEncoder);
}

// 중복 회원 가입 테스트
@Test
@DisplayName("중복 회원 가입 테스트")
public void saveDuplicateMemberTest(){
    Member member1 = createMember();
    Member member2 = createMember();
    memberService.saveMember(member1);
    Throwable e = assertThrows(AppException.class, () -> {
    memberService.saveMember(member2);});

    // 발생시킨 예외처리 메세지와 일치하는지 확인한다.
    assertEquals("김길동은 이미 있습니다.", e.getMessage());
}
```

* Ex 2) 마이페이지 중복 게시물 저장 테스트
```java
@Test
@DisplayName("마이페이지 중복 레시피 저장 테스트")
public void saveDuplicateCartTest() {
    Recipe recipe = saveRecipe();
    Member member = saveMember();

    CartRecipeDto cartRecipeDto = new CartRecipeDto();
    cartRecipeDto.setRecipeId(recipe.getId());

    Long cartRecipeId = cartService.addCart(cartRecipeDto, member.getEmail());
    CartRecipe cartRecipe = cartRecipeRepository.findById(cartRecipeId)
            .orElseThrow(EntityNotFoundException::new);

		// 동일한 게시물을 한번 더 저장한다.
    // 발생시킨 예외처리 메세지와 일치하는지 확인한다.
    Throwable e = assertThrows(AppException.class, () -> {
        cartService.addCart(cartRecipeDto, member.getEmail());});
    assertEquals(recipe.getRecipeName() + "은 이미 저장되어있습니다.", e.getMessage());
}
```
</div>
</details>

<details>
<summary>느낀점</summary>
<div markdown="1">

- Test Code는 신세계였다. View가 없어도 코드가 맞는지 확인할 수 있다니...
- 하지만 내가 짠 Test Code의 오류로 맞게 코드를 짰지만 테스트코드가 실패한다던지, 틀린 코드를 짰지만 테스트코드가 성공한다던지... 이런 현상들이 반복돼서 아직까지는 View의 최종 확인을 받는다.
- Test Code에 대한 더 깊은 이해와 학습을 통해 구현하고자 하는 기능의 테스트코드를 작성하고, 그를 통한 프로젝트 진행 방식을 적용시켜보고 싶다.

</div>
</details>

<br>
<br>
<br>

## 🚵🏻 후기 & 앞으로 개선할 내용
```text
* 한 줄 정리 : 어려울수록 기본에 충실해야 한다.

1. 처음부터 많은 것을 하려 했을 땐 앞이 막막했습니다.
하지만 어려울수록 기본으로 돌아가자는 사실을 명심했고, 
작은 기능부터 만들어나가는 것을 선택했습니다.
- 회원 가입 → 회원이 등록하는 게시물 → 게시물 이미지 등록 → 게시물 마이페이지 저장
- 이후 예외 상황이 발생하는 경우를 생각해보고, 하나씩 적용시켜보았습니다.

2. JPA를 사용하려면, 객체지향에 대한 깊은 이해가 필요하다는 것을 알게되었습니다.
객체지향은 정말 어렵지만, 매우 중요한 내용이고 근본입니다.

3. 프로젝트에 대한 추가적인 생각들은, 곧 나의 부족한 부분을 채워가는 과정이다.
- 기능의 전체적인 큰 틀을 만들어 놓고, 예외 발생과 구조에 대한 생각을 하면서 
프로젝트의 부족한 부분들이 보였습니다.
- 그 부분을 개선해나가는 과정에선 또 다른 부족한 점들이 보이는 것이 반복되었습니다.
- 개발을 처음 시작했을 땐 부족한 부분을 마주하는 것이 두려웠지만, 
지금은 성장해나가는 과정이라는 생각으로 부딪혀보고 있습니다

5. QueryDSL이 어렵고 와닿지 않는 개념이이었습니다.
- SQLMapper로 검색 기능을 만들었을 땐, 직관적이어서 이해가 빠르게 되었는데, 
Querydsl은 매우 어렵게 다가왔습니다.
- Java 코드를 작성하듯이 쿼리문을 작성하는 것이 신세계였습니다.

6. 더 많은 Test Code의 학습이 필요하다는 걸 느낄수록 아쉬웠습니다.
- 스스로 작성한 Test Code의 로직이 틀려, 틀린 테스트케이스를 만들어도 통과가 되는 현상이 나타났습니다.
- Test Code에 대한 더 깊은 이해와 학습을 통해 구현하고자 하는 기능의 테스트코드를 작성하고, 
그에 대한 프로젝트 진행 방식을 적용시켜보고 싶습니다다.


더 자세한 내용은 Notion에 있습니다.

```

<br>
<br>

---

<br>
<br>

더 자세한 내용은 Notion에 있습니다.