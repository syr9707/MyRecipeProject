# 🧑🏻‍🍳 Share My Recipe!

> 나만의 레시피를 공유해봐요! 🥗


## 📌 목차
1. [개요](#-개요)
2. [사용 언어 및 개발 환경](#-사용-언어-및-개발-환경)
3. [프로젝트 목적](#-프로젝트-목적)
4. [DB 구조](#-db-구조)
5. [구현 기능](#-구현-기능)
6. [학습 내용 & 개선된 내용](#-학습-내용-&-개선된-내용)



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
0. 프로젝트 목적 변경
> View Page에만 집중 → 코드에 집중

<br>

1. JPA 적용하기
> MyBatis를 사용했던 지난 프로젝트 → JPA 적용하기

<br>

2. Custom Exception 적용하기
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

3. DTO 적용하기
> DTO의 존재를 몰라 Entity를 그대로 반환 → DTO 적용

<br>

4. Test Code 작성하기
> 매번 View Page를 통해 의도한 결과가 맞는지 확인 → Test Code 적용





