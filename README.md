# 🧑🏻‍🍳 Share My Recipe!

> 나만의 레시피를 공유해봐요! 🥗


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


* 나만의 레시피(게시글) 등록
    * 레시피(게시글) 등록 / 수정 / 삭제
    * 레시피(게시글) 이미지 등록
    * 회원이 아닐 시 레시피(게시글) 등록 불가


* 공유된 레시피 저장
  * 회원이 아닐 시 레시피(게시글) 저장 불가
  * 레시피 중복 저장 불가능


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
<details>
<summary>[이전 상황] MyBais를 이용해 구현했던 검색 기능 코드, DB 쿼리만 날렸던 프로젝트</summary>
<div markdown="1">

* Ex) 게시물 검색
* [Controller]
```java
// 직업 검색
@RequestMapping("/jobsearchtest")
public String jobSearch(@RequestParam HashMap<String, Object> param, Model model) {
    ArrayList<JobVO> jobList = jobService.jobSearch(param);
    model.addAttribute("jobList", jobList);

    return "job/job_search_result";
}
```

* [SQL Mapper]
```xml
<!-- 게시물 검색 -->
<select id="jobSearch" parameterType="hashmap" resultMap="jobResult">
	SELECT * FROM job WHERE
	jobName LIKE CONCAT('%', #{keyword}, '%')
</select>
```
</div>
</details>

<details>
<summary>[이번 프로젝트 시] JPA를 이용해 구현한 검색 기능 코드</summary>
<div markdown="1">

* querydsl을 적용시켜 본 코드
```java
/**
 * 검색어가 null이 아니면, 게시물명에 해당 검색어가 포함되는 게시물을 조회하는 조건 반환
 *
 * BooleanExpression ; null 반환 시 자동으로 조건절에서 제거됨
 * 단, 모든 조건이 null인 경우 장애 발생
 * */
private BooleanExpression recipeNameLike(String searchQuery) {
    return StringUtils.isEmpty(searchQuery) ? null : QRecipe.recipe.recipeName.like("%" + searchQuery + "%");
}
```
</div>
</details>

<br>

### 2. Custom Exception 적용하기
> 예외 처리를 전혀 하지 않았던 지난 프로젝트 → 예외 처리 적용
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
</div>
</details>

<details>
<summary>[이번 프로젝트 시] 예외 처리를 적용해보았던 이번 프로젝트</summary>
<div markdown="1">

* Ex) 마이페이지에 게시물 저장 시, 중복 저장 처리 : 마이페이지 컨트롤러
```java
try {
    cartRecipeId = cartService.addCart(cartRecipeDto, email);
} catch (AppException e) { // 만들어놓은 AppException으로 예외처리를 한다.
    model.addAttribute("errorMessage", e.getMessage()); // 예외처리 메세지를 마이페이지 view에 전달
    return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
}
```

* Service
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

<br>

### 3. DTO 적용하기
> DTO의 존재를 몰라 Entity를 그대로 반환 → DTO 적용
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
</div>
</details>

<br>

### 4. Test Code 작성하기
> 매번 View Page를 통해 의도한 결과가 맞는지 확인 → Test Code 적용
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

* Ex) 중복 회원 가입 테스트
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
</div>
</details>

<br>
<br>
<br>


