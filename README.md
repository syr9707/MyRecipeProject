# 🧑🏻‍🍳 Share My Recipe!

> 나만의 레시피를 공유해봐요! 🥗

<br>

**💡 프로젝트에 대한 더 자세한 내용은 첨부한 Notion에 있습니다.**

## 📌 목차
1. [개요](#-개요)
2. [사용 언어 및 개발 환경](#-사용-언어-및-개발-환경)
3. [프로젝트 목적](#-프로젝트-목적)
4. [DB 구조](#-db-구조)
5. [구현 기능](#-구현-기능)
6. [학습 내용 & 개선된 내용](#-학습-내용--개선된-내용)



## ✔ 개요
* 개발 기간
  * 2023.01.01 ~
* 개발 인원
  * 개인 프로젝트


## ✔ 사용 언어 및 개발 환경
- IntelliJ
- Java 11
- Spring Boot 2.7
- Maven
- Spring Data JPA
- MySQL
- Thymeleaf


## ✔ 프로젝트 목적
* 국비 교욱에서 배운 MyBatis가 아닌, 후에 개인적으로 공부한 
  * **JPA** 적용
  * **Custom Exception** 적용
  * **DTO** 적용
  * **Test Code** 작성
  
  프로젝트

## ✔ DB 구조
![](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/fabfbe87-79bc-4ba8-8906-2b569277681f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230130%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230130T042206Z&X-Amz-Expires=86400&X-Amz-Signature=3c801411256bf5de2d5a1e7c6221c597c5cf9b50ec59851446d241c3d99b0af7&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)



## ✔ 구현 기능
* Spring-Security를 활용한 회원가입
  * 비밀번호 암호화 저장
  * 중복 아이디 회원가입 불가능


* 레시피(게시물) 등록
    * 조회수 측정
    * 등록 / 삭제 / 조회 / 수정(ADMIN 권한이 없을 시 비활성)
    * 레시피(게시글) 이미지 등록
    * 회원이 아닐 시 레시피(게시글) 등록 불가


* 레시피(게시물) 저장
  * 회원이 아닐 시 레시피(게시물) 저장 불가
  * 레시피(게시물) 중복 저장 불가능


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

하지만 후에, JPA를 많이 사용한다는 것을 알게 되고
개인적으로 학습 후 적용시켰습니다.

시작할 땐 JPA의 개념이 MyBatis처럼 SQL 쿼리에 객체를 Mapping만 하는
단순 작업인 줄 알았습니다.

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

하지만 회원 가입과 로그인 뿐 아니라 '서비스를 이용하는 모든 과정'에선, 
여러가지 상황들과 오류들이 발생할 수 있다는 것을 알게 되었습니다.

따라서 발생할 수 있는 여러 예외 상황들에 대한 것들을 고민해보게 되었습니다.

💡 그 과정에선 '예외를 처리하는 방법은 여러가지'이고, 
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

Test Code를 작성함으로써 코드의 추가 또는 변경이 있을 경우 
문제를 빠르게 파악하여 개발의 유지보수성을 증진시킬 수 있다는 것을 알게되었습니다.

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

---

<br>
<br>

더 자세한 내용은 Notion에 있습니다.