# ๐ง๐ปโ๐ณ Share My Recipe!

> ๋๋ง์ ๋ ์ํผ๋ฅผ ๊ณต์ ํด๋ด์! ๐ฅ

<br>

**๐ก ํ๋ก์ ํธ์ ๋ํ ๋ ์์ธํ ๋ด์ฉ์ ์ฒจ๋ถํ Notion์ ์์ต๋๋ค.**

## ๐ ๋ชฉ์ฐจ
1. [๊ฐ์](#-๊ฐ์)
2. [์ฌ์ฉ ์ธ์ด ๋ฐ ๊ฐ๋ฐ ํ๊ฒฝ](#-์ฌ์ฉ-์ธ์ด-๋ฐ-๊ฐ๋ฐ-ํ๊ฒฝ)
3. [ํ๋ก์ ํธ ๋ชฉ์ ](#-ํ๋ก์ ํธ-๋ชฉ์ )
4. [ํ๊ธฐ](#-ํ๊ธฐ)
5. [DB ๊ตฌ์กฐ](#-db-๊ตฌ์กฐ)
6. [๊ตฌํ ๊ธฐ๋ฅ](#-๊ตฌํ-๊ธฐ๋ฅ)
7. [์ฃผ์ ์งํ ์ํฉ](#-์ฃผ์-์งํ-์ํฉ)
8. [ํ์ต ๋ด์ฉ & ๊ฐ์ ๋ ๋ด์ฉ](#-ํ์ต-๋ด์ฉ--๊ฐ์ ๋-๋ด์ฉ)
9. [ํ๊ธฐ & ์์ผ๋ก ๊ฐ์ ํ  ๋ด์ฉ](#-ํ๊ธฐ--์์ผ๋ก-๊ฐ์ ํ -๋ด์ฉ)

<br>

## โ ๊ฐ์
* ๊ฐ๋ฐ ๊ธฐ๊ฐ
  * 2023.01.01 ~
* ๊ฐ๋ฐ ์ธ์
  * ๊ฐ์ธ ํ๋ก์ ํธ

<br>

## โ ์ฌ์ฉ ์ธ์ด ๋ฐ ๊ฐ๋ฐ ํ๊ฒฝ
- Java 11
- Spring Boot 2.7
- Maven
- Spring Data JPA
- MySQL
- Thymeleaf
- IntelliJ

<br>

## โ ํ๋ก์ ํธ ๋ชฉ์ 
```text
๐ก SpringBoot์ JPA๋ฅผ ์ด์ฉํ ๊ฐ์ธ ํ๋ก์ ํธ ์๋๋ค.

์ด๋ฒ ํ๋ก์ ํธ์ ๋ชฉํ๋
- ํ๋ก์ ํธ ๋ชฉ์  ๋ณ๊ฒฝํ๊ธฐ (View ์ค์ฌ์ ํ๋ก์ ํธ โ ์ฝ๋์ ์ง์คํ ํ๋ก์ ํธ)
- ํ์ตํ JPA ์ ์ฉํ๊ธฐ
- Exception๊ณผ Custom Exception ์ฒ๋ฆฌ ์ ์ฉํ๊ธฐ
- DTO ๊ตฌ์กฐ ์ ์ฉํ๊ธฐ
- Test Code ์์ฑํ๊ธฐ
  
์๋๋ค.

๋ํ ๊ฐ์ ๊ฒฐ๊ณผ๋ฅผ ์ํด ๋ค๋ฅธ ๊ธฐ์ ๋ค์ ์ ์ฉํด๋ณด๋ ๊ฒ์๋๋ค.

2022๋ ๊ต์ก์ ๋ฐ์ผ๋ฉฐ ์ฒ์ Spring Framework๋ฅผ ์ ํ๊ฒ ๋์์ต๋๋ค.
"๊ฒ์ํ ๋ง๋ค๊ธฐ"๋ฅผ ํตํด
์น ์ ํ๋ฆฌ์ผ์ด์์ ๋์ ํ๋ฆ์ ํ์ตํ๊ณ ์ ํ๋ก์ ํธ๋ฅผ ์ ์ํ์์ต๋๋ค.
```

<br>

## โ ํ๊ธฐ
```text
๊ทธ์  ํ๋ก์ ํธ๊น์ง ์ ์ฉํด๋ณด์ง ์์๋ ๊ฒ๋ค์ ์ ์ฉํด๋ณด์์ต๋๋ค.

๋ฐ๋ผ์ ๊ฐ๋ฐ ํ๊ฒฝ์ ๋ง์ ๋ณํ๊ฐ ์์์ต๋๋ค.

ํนํ ๊ฐ์ ๊ธฐ๋ฅ์ ๋ค๋ฅธ ๊ธฐ์ ๋ค๋ก ์ ์ฉํด๋ณด๋ ๊ณผ์ ์ ๋งค์ฐ ํฅ๋ฏธ๋ก์ ์ต๋๋ค.

๋ํ '๊ฐ์ธ'์ผ๋ก ์งํํ๋ ๊ฒฝํ์ 'ํ'์ผ๋ก ์งํํ์ ๋๋ ๋๋ ์ ์์๋ ๊ฒ์ ์๊ฒ ๋์์ต๋๋ค.
ํ ํ๋ก์ ํธ๋ฅผ ํ์ ์์, ๋ค๋ฅธ ํ์์ ์ค๋ ฅ์ ๊ณง ๋ด ์ค๋ ฅ์ผ๋ก ์ฐฉ๊ฐํ๋ค๋ ๊ฒ์ 
์ด๋ฒ ๊ฐ์ธ ํ๋ก์ ํธ๋ฅผ ๊ฒฝํํ๋ฉฐ ๊นจ๋ซ๊ฒ ๋์์ต๋๋ค.
๋ฐ๋ผ์ ์ ๊ฐ ๋น์ฐํ ์๊ณ  ์๋ค๊ณ  ์๊ฐํ๋ '๊ธฐ๋ณธ'์ ๊ด๋ จ๋ ๊ฒ๋ค์ ๋ถ์กฑํจ์ ๋๊ปด 
ํ๋์ฉ ์ฑ์ฐ๊ฒ ๋๋ ์๋ฏธ ์๋ ํ๋ก์ ํธ๊ฐ ๋์์ต๋๋ค.

์ด๋ฒ ๊ฐ์ธ ํ๋ก์ ํธ๋ฅผ ๊ณ๊ธฐ๋ก 
'๊ธฐ๋ณธ'์ด๋ ์ฌ์ด ๊ฒ์ด ์๋ '์ค์ํ ๊ฒ'์์ ์๊ฒ ๋์์ต๋๋ค.
๋๋ฌธ์ ์ด๋ ค์ธ์๋ก ๊ธฐ๋ณธ์ ์ถฉ์คํด์ผ ํ๋ค๋ ๊ฒ์ ๋ช์ฌํ์ต๋๋ค.
```

<br>

## โ DB ๊ตฌ์กฐ
![](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0026268a-e4c0-4ad0-a370-29e756bcb0dd/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230303%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230303T060638Z&X-Amz-Expires=86400&X-Amz-Signature=f7ccf5b9b080d467617313dbb16fe93d863a35cf48e0d30e07511abfb9e40378&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

<br>

## โ ๊ตฌํ ๊ธฐ๋ฅ
1. Spring-Security๋ฅผ ํ์ฉํ ํ์๊ฐ์ 
   1. ๋น๋ฐ๋ฒํธ ์ํธํ ์ ์ฅ 
   2. ์ค๋ณต ์์ด๋ ํ์๊ฐ์ ๋ถ๊ฐ๋ฅ


2. ๋ ์ํผ(๊ฒ์๋ฌผ) ๋ฑ๋ก 
   1. ์กฐํ์ ์ธก์ 
   2. ๋ฑ๋ก / ์ญ์  / ์กฐํ / ์์ (ADMIN ๊ถํ์ด ์์ ์ ๋นํ์ฑ)
   3. ๊ฒ์๊ธ ๋ฑ๋ก์๋ง ์์  ๊ฐ๋ฅ
   4. ํ์์ด ์๋ ์ ๊ฒ์๊ธ ๋ฑ๋ก ๋ถ๊ฐ


3. ๊ฒ์๊ธ ์ด๋ฏธ์ง ๋ฑ๋ก


4. ๊ฒ์๊ธ ์ ์ฅ
   1. ํ์์ด ์๋ ์ ๊ฒ์๊ธ ์ ์ฅ ๋ถ๊ฐ
   2. ๊ฒ์๊ธ ์ค๋ณต ์ ์ฅ ๋ถ๊ฐ๋ฅ


5. ๊ฒ์๊ธ ๋๊ธ

<br>
<br>

## ๐ ์ฃผ์ ์งํ ์ํฉ
0. RESTful API ์ ์ฉ
    - [๋ชจ๋  API๋ฅผ POST๋ก ๋ณด๋๋ ๊ณผ๊ฑฐ์์, GET, POST, PUT, DELETE๋ก ๋ชฉ์ ์ ๋ง๊ฒ ๋๋๊ธฐ](https://ummmmchicken.tistory.com/entry/JPA-1-N-%EA%B4%80%EA%B3%84%EB%A5%BC-%EB%B6%84%EC%84%9D%ED%95%B4%EB%B3%B4%EC%9E%90)
1. MyBatis โ JPA
    - [SQL Mapper์ธ MyBatis์ Java ORM์ธ JPA์ ์ฐจ์ด๋ฅผ ์ฒด๊ฐ](https://ummmmchicken.tistory.com/entry/JPA-MyBatis%EC%99%80-JPA-%EB%8F%84%EB%8C%80%EC%B2%B4-%EB%AD%90%EA%B0%80-%EB%8B%A4%EB%A5%BC%EA%B9%8C)
    - [1 : N ๊ด๊ณ์ ์์์ฑ ์ ์ด ๊ตฌํ](https://ummmmchicken.tistory.com/entry/JPA-1-N-%EA%B4%80%EA%B3%84%EB%A5%BC-%EB%B6%84%EC%84%9D%ED%95%B4%EB%B3%B4%EC%9E%90)
2. Spring Security ์ ์ฉ
    - [Spring Security๋ฅผ ์ฌ์ฉํ๊ธฐ ์ํ ๋ถ์](https://ummmmchicken.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0%EB%A5%BC-%EB%B6%84%EC%84%9D%ED%95%B4%EB%B3%B4%EC%9E%90)
    - [๋จ์ DB insert์์, Spring Security๋ฅผ ์ด์ฉํด ๊ถํ์ ๋ถ์ฌํ๋ ๊ตฌํ๊ธฐ](https://ummmmchicken.tistory.com/entry/Spring-Security%EB%A1%9C-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%EC%9D%84-%ED%95%B4%EB%B3%B4%EC%9E%90-1)
3. Custom Exception ์ ์ฉ
    - [์ํฐํฐ ๋ณ ์์ธ ๋ฐ์ ์ํฉ์ ํ ๊ณณ์ ๋ชจ์ ์ฒ๋ฆฌํ๊ธฐ](https://ummmmchicken.tistory.com/entry/Custom-Exception-%ED%95%B4%EB%B3%B4%EA%B8%B0)
    - [Ajax๋ก ์ผ์ผ์ด ์ฒดํฌํ๋ ๊ณผ๊ฑฐ์์, Spring BindingResult์ Validation์ ์ด์ฉํ ์ ํจ์ฑ ๊ฒ์ฆ ๊ตฌํ๊ธฐ](https://ummmmchicken.tistory.com/entry/%EC%97%90%EB%9F%AC-%ED%9A%8C%EC%9B%90-%EA%B0%80%EC%9E%85-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%97%90%EB%9F%AC-%EC%B2%98%EB%A6%AC%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EC%B0%B0)
4. DTO ์ ์ฉ
    - [DTO๋ ์ ๋ง๋๋ ๊ฒ์ผ๊น?์ ๋ํ ๊ณ ์ฐฐ](https://ummmmchicken.tistory.com/entry/%EC%83%9D%EA%B0%81%EB%93%A4-%EB%8F%84%EB%8C%80%EC%B2%B4-DTO%EB%A5%BC-%EC%99%9C-%EB%A7%8C%EB%93%9C%EB%8A%94-%EA%B2%83%EC%9D%B8%EA%B0%80%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EC%B0%B0)
    - [Entity ์ธ๋ถ ๋ธ์ถ์ ๋๋นํด, ์ฉ๋์ ๋ฐ๋ฅธ EntityDTO 4๊ฐ๋ก ๋๋๋ ๊ตฌํ๊ธฐ](https://ummmmchicken.tistory.com/entry/CRUD%EB%A5%BC-%EB%B6%84%EC%84%9D%ED%95%B4%EB%B3%B4%EC%9E%90-1-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EC%83%9D%EC%84%B1-API)
5. Test Code ์์ฑ
    - Test Code๋ฅผ ํตํด View๊ฐ ์์ด๋ ๊ตฌํ ๊ธฐ๋ฅ์ด ์ ์ ์๋ ๋๋์ง ํ์คํธ ๊ฐ๋ฅ
    - [Mock Test๋ก Security ๊ถํ ํ์คํธ ๊ตฌํ๊ธฐ](https://ummmmchicken.tistory.com/entry/Spring-Security%EB%A1%9C-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%EC%9D%84-%ED%95%B4%EB%B3%B4%EC%9E%90-3-SecurityConfig-%EB%B0%8F-%EB%A1%9C%EA%B7%B8%EC%9D%B8)


<br>
<br>


## โ ํ์ต ๋ด์ฉ & ๊ฐ์ ๋ ๋ด์ฉ
### 0. ํ๋ก์ ํธ ๋ชฉ์  ๋ณ๊ฒฝ
> View Page์๋ง ์ง์ค โ ์ฝ๋์ ์ง์ค
<details>
<summary>[์ด์  ์ํฉ] ๋ณด์ฌ์ง๋ View Page์๋ง ์ง์ค</summary>
<div markdown="1">

```
๊ตญ๋น๊ต์ก์ ๋ฐ์ผ๋ฉฐ ํ & ๊ฐ์ธ ํ๋ก์ ํธ๋ฅผ ํ์ ์์ ๋ณด์ฌ์ง๋ View Page์๋ง ์ง์คํ์ต๋๋ค.

๋ฐ๋ผ์ ์ฝ๋๊ฐ ์ด๋ป๊ฒ ๋๋ , 
๋ณด์ฌ์ง๋ ํ๋ฉด(View)๋ง ์ํ๋ ๊ฒฐ๊ณผ๊ฐ ๋์ค๊ฒ๋ ์ฝ๋๋ฅผ ์์ฑํ์ต๋๋ค.
๊ทธ ๊ฒฐ๊ณผ 
์ด๋ค ๊ธฐ๋ฅ์ ๊ตฌํํ๋ฉด, ๋ค๋ฅธ ๊ธฐ๋ฅ์ ๋ฌธ์ ๊ฐ ์๊ธฐ๊ณ  
๊ทธ ๋ฌธ์ ๋ฅผ ํด๊ฒฐํ๋ฉด, ๋๋ค๋ฅธ ๋ฌธ์ ๊ฐ ์๊ธฐ๋ ์ํฉ์ด ๋ฐ๋ณต๋์ต๋๋ค.

๊ทผ๋ณธ์ ์ธ ๋ฌธ์ ๋ฅผ ํด๊ฒฐํ์ง ๋ชปํ๊ณ  ๋ฌธ์  ์ํฉ์ ๋ง๊ธฐ์๋ง ๊ธํ์ต๋๋ค.
๊ฒฐ๊ณผ์ ์ผ๋ก , ๋งค์ฐ ์ง์ ๋ถํ๊ณ  ์ ์ ์๋ 
์ฆ, ์ ์ง๋ณด์๊ฐ ๋งค์ฐ ์ด๋ ค์ด ์ฝ๋๊ฐ ์ต์ข ๊ฒฐ๊ณผ๋ฌผ์ด ๋์์ต๋๋ค.

๊ทธ๋์๋ ๊ทธ ๋ฐฉ์์ด ๋ง๋ ๋ฐฉ์์ธ ์ค ์์์ต๋๋ค.

ํ์ง๋ง UI์ ์ ๊ฒฝ์ฐ๋ ๊ฒ์ด ์๋ ๊ธฐ๋ฅ ๊ตฌํ ์ฝ๋์ ์ง์คํด์ผํ๋ค๋ ์ฌ์ค์ ์๊ฒ๋์๊ณ , 
์ด๋ฒ ํ๋ก์ ํธ๋ถํด ์ฝ๋์ ์ง์คํ๋ ๊ฒ์ผ๋ก ๋ชฉ์ ์ ๋ณ๊ฒฝํ์ต๋๋ค.
```
</div>
</details>

<details>
<summary>[์ด๋ฒ ํ๋ก์ ํธ ์] ๊ธฐ๋ฅ ๊ตฌํ ์ฝ๋์ ์ง์ค</summary>
<div markdown="1">

```
์ ์ผ ํฐ ๋ณํ๋ ์ฌํ๊ป ๋ฐฐ์์๊ณ  ์ ์ฉ์์ผฐ๋ MyBatis๊ฐ ์๋, 
์๋กญ๊ฒ ํ์ตํ JPA๋ฅผ ์ด์ฉํ๋ ๊ฒ์ด์์ต๋๋ค.

๋ํ Test Code๋ ํ๋ก์ ํธ์ ์ ์ฉ์์ผ๋ณด์์ต๋๋ค.
๊ทธ์ ๋ฐ๋ผ ์์ธ ์ํฉ๋ค์ ๋ํ ์ฝ๋๋ค๋ ์๊ฐํด๋ณด๊ฒ ๋์์ต๋๋ค.
```
</div>
</details>

<br>

### 1. JPA ์ ์ฉํ๊ธฐ
> MyBatis๋ฅผ ์ฌ์ฉํ๋ ์ง๋ ํ๋ก์ ํธ โ JPA ์ ์ฉํ๊ธฐ

```text
๐ค MyBatis๋ฅผ ๋ฐฐ์ธ ๋, ๋น์ฐํ ๊ทธ ๊ธฐ์ ๋ง ์ฐ๋ ๊ฒ์ธ ์ค ์์์ต๋๋ค.

์์ํ  ๋ JPA์ ๊ฐ๋์ด MyBatis์ฒ๋ผ SQL ์ฟผ๋ฆฌ์ ๊ฐ์ฒด๋ฅผ Mapping๋ง ํ๋ 
๋จ์ ์์์ธ ์ค ์์์ต๋๋ค.

Why? ์ JPA๋ฅผ ์ฌ์ฉํ์๊น?
1. ๊ฐ์ฒด ์ค๊ณ ์ค์ฌ์ผ๋ก ์์ฐ์ฑ์ ๋์ผ ์ ์์ต๋๋ค.
2. ํ๋๋ฅผ ๋ณ๊ฒฝํด๋ ์์ ํด์ผ ํ  ์ฝ๋๊ฐ ์ค์ด๋ค์ด ์ ์ง๋ณด์๊ฐ ํธ๋ฆฌํฉ๋๋ค.
3. JPA๋ ์ฐ๊ด๊ด๊ณ์ ๊ด๋ จ๋ ํจ๋ฌ๋ค์์ ๋ถ์ผ์น๋ฅผ ํด๊ฒฐํด์ค๋๋ค.
4. ์ ํ๋ฆฌ์ผ์ด์๊ณผ ๋ฐ์ดํฐ๋ฒ ์ด์ค ์ฌ์ด์์ ๋ค์ํ ์ฑ๋ฅ ์ต์ ํ ๊ธฐํ๋ฅผ ์ ๊ณตํฉ๋๋ค.
๋ฑ๋ฑ 

ํ์ง๋ง ํ์ตํ๋ค๋ณด๋,
๐ก 'JPA๋ Java์ OOP์ ๊ฐ๋์ ์ ๋๋ก ์๊ณ  ํ์ฉํ  ์ค ์์์ผ ํ๋ ๋ฑ
์ ๋๋ก ์ตํ๊ธฐ๊ฐ ๋งค์ฐ ๊น๋ค๋กญ๊ณ  ์ด๋ ต๋ค'๋ ์ฌ์ค์ ์๊ฒ ๋์์ต๋๋ค.
```

<details>
<summary>[์ด์  ์ํฉ] MyBais๋ฅผ ์ด์ฉํด ๊ตฌํํ๋ ํ์์ ๋ณด ์ ์ฅ & ํ์์ ๋ณด ์์ </summary>
<div markdown="1">

<details>
<summary>Ex 1) ํ์์ ๋ณด ์ ์ฅ</summary>
<div markdown="1">

* SQL Mapper
```xml
<!-- ํ์ ๊ฐ์ -->
<insert id="insertMember" parameterType="com.jobdongsan.project.model.MemberVO">
	INSERT INTO member (memId, memPw, memName, memEmail, memChildBirth, memHP, memZipcode, memAddress1, memAddress2)
	VALUES (#{memId}, #{memPw}, #{memName}, #{memEmail}, #{memChildBirth}, #{memHP}, #{memZipcode}, #{memAddress1}, #{memAddress2})
</insert>

<!-- Oauth ํ์ ๊ฐ์  -->
<insert id="insertOauthMember" parameterType="com.jobdongsan.project.model.MemberVO">
	INSERT INTO member (memId, memPw, memName, memEmail, profileImg, provider, providerId)
	VALUES (#{memId}, #{memPw}, #{memName}, #{memEmail}, #{profileImg}, #{provider}, #{providerId})
</insert>
```

* MemberDAO Interface
```java
public void insertMember(MemberVO vo); // ํ์ ๊ฐ์
public void insertOauthMember(MemberVO vo); // SNS ํ์ ๊ฐ์
```

* MemberService
```java
// ํ์ ๊ฐ์
@Override
public void insertMember(MemberVO vo) {
	// ๋น๋ฐ๋ฒํธ ์ํธํ ์ฒ๋ฆฌํ ํ mapper์๊ฒ ์ ๋ฌ
	String encodedPwd = pwdEncoder.encode(vo.getMemPw());
	vo.setMemPw(encodedPwd);
	
	dao.insertMember(vo); // ํ์์ ๋ณด ์ ์ฅ(INSERT) SQL Mapper
}

// SNS ํ์ ๊ฐ์
@Override
public void insertOauthMember(MemberVO vo) {
	dao.insertOauthMember(vo);
}
```

</div>
</details>

<details>
<summary>Ex 2) ํ์์ ๋ณด ์์ </summary>
<div markdown="1">

* SQL Mapper
```xml
<!-- ํ์ ์ ๋ณด ์์  -->
<update id="updateMemberInfo" parameterType="com.jobdongsan.project.model.MemberVO">
	UPDATE member SET memPw = #{memPw}, memName = #{memName}, memEmail = #{memEmail},
	memChildBirth = #{memChildBirth}, memHP = #{memHP}, memZipcode = #{memZipcode}, memAddress1 = #{memAddress1},
	memAddress2 = #{memAddress2}, profileImg = #{profileImg} WHERE memId = #{memId}
</update>
```

* MemberDAO Interface
```java
public void updateMemberInfo(MemberVO vo); // ํ์ ์ ๋ณด ์์ 
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
<summary>[์ด๋ฒ ํ๋ก์ ํธ ์] JPA๋ฅผ ์ด์ฉํด ๊ตฌํํ ํ์์ ๋ณด ์ ์ฅ & ํ์์ ๋ณด ์์ </summary>
<div markdown="1">

<details>
<summary>Ex 1) ํ์์ ๋ณด ์ ์ฅ</summary>
<div markdown="1">

* MemberRepository
```java
public interface MemberRepository extends JpaRepository<Member, Long> {
    // ์ด๋ฉ์ผ๋ก ์ค๋ณต ๊ฒ์ฌ
    Member findByEmail(String email);
}
```

* MemberService
```java
public Member saveMember(Member member) {
    validateDuplicateMember(member); // ํ์๊ฐ์ ์ค๋ณต ๊ฒ์ฌ
    return memberRepository.save(member); // ํ์ ์ ๋ณด ์ ์ฅ
}

/**
 * ํ์๊ฐ์ ์ค๋ณต ๊ฒ์ฌ
 * ์ด๋ฉ์ผ ์ค๋ณต ๋ถ๊ฐ๋ฅ
 * */
private void validateDuplicateMember(Member member) {
    Member findMember = memberRepository.findByEmail(member.getEmail()); // ์ด๋ฉ์ผ๋ก ์ฐพ์ ํ์์ Member์ ๋ด๋๋ค.
    if(findMember != null) {
        // ์์ธ์ฒ๋ฆฌ
        throw new AppException(ErrorCode.MEMBERNAME_DUPLICATED, findMember.getName() + "์ ์ด๋ฏธ ์์ต๋๋ค.");
    }
}
```

</div>
</details>

<details>
<summary>Ex 2) ํ์์ ๋ณด ์์  : ์ํ๋ ์ ๋ณด๋ง ์ ํํด ์์ </summary>
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
<summary>๋๋์ </summary>
<div markdown="1">

- JPA ๋๋ถ์ SQL์ ์์กด์ ์ธ ์ฝ๋๋ฅผ ์ง์ง ์๊ณ , Java ์ค์ฌ์ ์ฝ๋๋ฅผ ์งค ์ ์์๋ค.
- SQL Mapper๋ก ๊ตฌํํ์ ๋์ฒ๋ผ ์์ฃผ ์ฐ๋ CRUD ๋ฉ์๋๋ฅผ ์ง์  ๋ค ์์ฑํ์ง ์์๋ ๋ผ ์ฝ๋์ ์์ด ์ค์๋ค.
- JPA๋ ๊ธฐ๋ณธ์ ์ธ CRUD๋ฅผ ์ ๊ณตํด ๋น์ฆ๋์ค ๋ก์ง์ ๋ณด๋ค ๋ ์ง์คํ  ์ ์๋ค.
- ๊ฒ์ ๊ธฐ๋ฅ์ ํํด ์์ง๊น์ง๋ Querydsl๋ณด๋ค myBatis๊ฐ ์ง๊ด์ ์ด์ด์ ๊ทธ๋ฐ์ง ๋ ์ดํด๊ฐ ์ฝ๋ค.
- Querydsl์ ๋ ๊น์ ์ดํด์ ํ์ต์ด ํ์ํ๋ค.

</div>
</details>

<br>

### 2. Exception๊ณผ Custom Exception ์ ์ฉํ๊ธฐ
> ์์ธ ์ฒ๋ฆฌ๋ฅผ ์ ํ ํ์ง ์์๋ ์ง๋ ํ๋ก์ ํธ โ ์์ธ ์ฒ๋ฆฌ ์ ์ฉ

```text
๐ค ํ์ ๊ฐ์๊ณผ ๋ก๊ทธ์ธ ๊ธฐ๋ฅ์ ๊ฐ๋จํ ์ค ์์์ต๋๋ค.

ํ์ง๋ง ํ์ ๊ฐ์๊ณผ ๋ก๊ทธ์ธ ๋ฟ ์๋๋ผ ์๋น์ค๋ฅผ ์ด์ฉํ๋ ๋ชจ๋  ๊ณผ์ ์์ , 
์ฌ๋ฌ๊ฐ์ง ์ํฉ๋ค๊ณผ ์ค๋ฅ๋ค์ด ๋ฐ์ํ  ์ ์๋ค๋ ๊ฒ์ ์๊ฒ ๋์์ต๋๋ค.
๋ฐ๋ผ์ ๋ฐ์ํ  ์ ์๋ ์ฌ๋ฌ ์์ธ ์ํฉ๋ค์ ๋ํ ๊ฒ๋ค์ ๊ณ ๋ฏผํด๋ณด๊ฒ ๋์์ต๋๋ค.

Why? ์ Custom Exception์ ์จ์ผ๋ง ํ ๊น?
1. ์์ธ ๋ฉ์์ง๋ก๋ ์ถฉ๋ถํ ์๋ฏธ๋ฅผ ์ ๋ฌํ  ์ ์์ต๋๋ค.
2. ์์ธํ ์์ธ ์ ๋ณด๋ฅผ ์ ๊ณตํ  ์ ์์ต๋๋ค.
3. ์์ธ์ ๋ํ ๊ฒ๋ค์ ํ ๊ณณ์ ๊ด๋ฆฌํ  ์ ์์ต๋๋ค.
๋ฑ๋ฑ 

๐ก ๊ทธ ๊ณผ์ ์์  '์์ธ ์ฒ๋ฆฌ๋ฅผ ํ๋ ๋ฐฉ๋ฒ์ ์ฌ๋ฌ๊ฐ์ง'์ด๊ณ , 
'์์ธ ์ฒ๋ฆฌ๋ฅผ customํ์ฌ ์ฒ๋ฆฌํ  ์ ์๋ค๋ ๊ฒ'๋ ์๊ฒ ๋์์ต๋๋ค.
```

<details>
<summary>[์ด์  ์ํฉ] ์์ธ ์ฒ๋ฆฌ๋ฅผ ์ ํ ํ์ง ์์๋ ์ง๋ ํ๋ก์ ํธ๋ค</summary>
<div markdown="1">

* Ex) ๋ง์ดํ์ด์ง์ ๊ฒ์๋ฌผ ์ ์ฅ ์, ์ค๋ณต ์ ์ฅ ์ฒ๋ฆฌ
```java
// ๋ง์ดํ์ด์ง ๊ฒ์๋ฌผ ์ ์ฅ
@ResponseBody
@RequestMapping("/insert_video")
public String insertVideo(@RequestParam HashMap<String, Object> param, HttpSession session) {
	String result = null;
	String memId = (String)session.getAttribute("sid");
	
	param.put("memId", memId);

	// ์ ์ฅํ๋ ค๋ ๊ฒ์๋ฌผ์ด ๋ง์ดํ์ด์ง์ ์๋์ง ๊ฐฏ์๋ฅผ ์ฒดํฌํ๋ค.
	int count = videoService.checkVideo(Integer.parseInt((String)param.get("videoNo")), memId);
	if(count == 0) { // ๋ง์ฝ ๊ฒ์๋ฌผ์ด ์๋ค๋ฉด (๋ง์ดํ์ด์ง ๊ฒ์๋ฌผ 0๊ฐ)
		videoService.insertVideo(param);
		result = "0";
	}
	else { // ๋ง์ฝ ๊ฒ์๋ฌผ์ด ์๋ค๋ฉด, ์๋ฏธ์๋ ์ซ์(result = 1) ๋ฐํ
		result = "1";
	}
	
	return result;
}
```

* SQL Mapper : ๋ง์ดํ์ด์ง์ ๋์ผ ๊ฒ์๋ฌผ์ด ์กด์ฌํ๋์ง ํ์ธ
```xml
<!-- ๋ง์ดํ์ด์ง์ ๋์ผ ๊ฒ์๋ฌผ์ด ์กด์ฌํ๋์ง ํ์ธ -->
<!-- ํ์์ ๋ง์ดํ์ด์ง์ ์ ์ฅํ๊ณ ์ ํ๋ ๊ฒ์๋ฌผ์ ๊ฐ์ ์นด์ดํธ -->
<select id="checkVideo" parameterType="hashmap" resultType="int">
	SELECT COUNT(*)
	FROM my_history 
	WHERE videoNo=#{videoNo} AND memId=#{memId} 
</select>
```

</div>
</details>

<details>
<summary>[์ด๋ฒ ํ๋ก์ ํธ ์] ์์ธ ์ฒ๋ฆฌ๋ฅผ ์ ์ฉํด๋ณด์๋ ์ด๋ฒ ํ๋ก์ ํธ</summary>
<div markdown="1">

<details>
<summary>Ex 1) ํ์ ๊ฐ์ ์ค๋ณต ๊ฒ์ฌ</summary>
<div markdown="1">

* ๋จ๊ณ 1 : throw new IllegalStateException
```java
private void validateDuplicateMember(Member member) {
    Member findMember = memberRepository.findByEmail(member.getEmail()); // ์ด๋ฉ์ผ๋ก ์ฐพ์ ํ์์ Member์ ๋ด๋๋ค.
    if(findMember != null) { // ํ์ ์ ๋ณด๊ฐ ์กด์ฌํ๋ฉด
        // IllegalStateException ์์ธ์ฒ๋ฆฌ
        throw new IllegalStateException("์ด๋ฏธ ๊ฐ์๋ ํ์์๋๋ค.");
    }
}
```

* ๋จ๊ณ 2 : customํ AppException์ผ๋ก ์ฒ๋ฆฌ
```java
private void validateDuplicateMember(Member member) {
    Member findMember = memberRepository.findByEmail(member.getEmail()); // ์ด๋ฉ์ผ๋ก ์ฐพ์ ํ์์ Member์ ๋ด๋๋ค.
    if(findMember != null) { // ํ์ ์ ๋ณด๊ฐ ์กด์ฌํ๋ฉด
        // AppException ์์ธ์ฒ๋ฆฌ
        // MEMBERNAME_DUPLICATED(HttpStatus.CONFLICT, "")
        throw new AppException(ErrorCode.MEMBERNAME_DUPLICATED, findMember.getName() + "์ ์ด๋ฏธ ์์ต๋๋ค.");
    }
}
```

* ๋จ๊ณ 3 : RuntimeException์ ์์๋ฐ๋ BaseException ์์ฑ
```java
public interface BaseExceptionType {

    // ์๋ฌ ์ฝ๋
    int getErrorCode();

    // Http ์ํ
    HttpStatus getHttpStatus();

    // ์๋ฌ ๋ฉ์ธ์ง
    String getErrorMessage();

}
```
```java
public enum MemberExceptionType implements BaseExceptionType {

    // ํ์๊ฐ์, ๋ก๊ทธ์ธ์
    ALREADY_EXIST_USERNAME(600, HttpStatus.CONFLICT, "์ด๋ฏธ ์กด์ฌํ๋ ์์ด๋์๋๋ค."),
    NOT_FOUND_MEMBER(602, HttpStatus.NOT_FOUND, "ํ์ ์ ๋ณด๊ฐ ์์ต๋๋ค.");

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
<summary>Ex 2) ๋ง์ดํ์ด์ง์ ๊ฒ์๋ฌผ ์ ์ฅ ์, ์ค๋ณต ์ ์ฅ ์ฒ๋ฆฌ</summary>
<div markdown="1">

* CartController : ๋ง์ดํ์ด์ง ์ปจํธ๋กค๋ฌ
```java
try {
    cartRecipeId = cartService.addCart(cartRecipeDto, email);
} catch (AppException e) { // ๋ง๋ค์ด๋์ AppException์ผ๋ก ์์ธ์ฒ๋ฆฌ๋ฅผ ํ๋ค.
    model.addAttribute("errorMessage", e.getMessage()); // ์์ธ์ฒ๋ฆฌ ๋ฉ์ธ์ง๋ฅผ ๋ง์ดํ์ด์ง view์ ์ ๋ฌ
    return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
}
```

* CartService
```java
CartRecipe savedCartRecipe = cartRecipeRepository.findByCartIdAndRecipeId(cart.getId(), recipe.getId());

// ๋ ์ํผ ์ค๋ณต ์ ์ฅ
if(savedCartRecipe != null) { // ๋ง์ดํ์ด์ง์ ๊ฒ์๋ฌผ์ด ์ ์ฅ๋์ด ์๋ค๋ฉด
    // AppException์ CART_RECIPE_DUPLICATED๋ก ์์ธ์ฒ๋ฆฌ๋ฅผ ํ๋ค.
    throw new AppException(ErrorCode.CART_RECIPE_DUPLICATED, recipe.getRecipeName() + "์ ์ด๋ฏธ ์ ์ฅ๋์ด์์ต๋๋ค.");
}

CartRecipe cartRecipe = CartRecipe.createCartRecipe(cart, recipe);
cartRecipeRepository.save(cartRecipe);
```

</div>
</details>

</div>
</details>

<details>
<summary>๋๋์ </summary>
<div markdown="1">

- Custom Exception์ Test Code ์คํจ๋ก ๋ค์ ์๋ ์ฝ๋๋ก ๋์๊ฐ ๊ฒ๋ค์ด ์์ด ์์ฝ๋ค.
- ์ค๋ฅ ์์ด ์์ธ ์ฒ๋ฆฌ๋ฅผ ํ  ์ ์๋ ๋ฐฉ๋ฒ์ ๋ฐฐ์ฐ๊ณ  ์ถ๋ค.
- ๋ด๊ฐ ๊ตฌํํ Custom Exception์ด ๋ง๋ ๋ฐฉ์์ธ์ง ๋ชจ๋ฅด๊ฒ ๋ค. ์ ๋๋ก ๋ฐฐ์ฐ๊ณ  ์ถ๋ค.

</div>
</details>

<br>

### 3. DTO ์ ์ฉํ๊ธฐ
> DTO์ ์กด์ฌ๋ฅผ ๋ชฐ๋ผ Entity๋ฅผ ๊ทธ๋๋ก ๋ฐํ โ DTO ์ ์ฉ

```text
๐ค ์ํฐํฐ๋ฅผ ์ง์  ๋ฐํํ๋ ์ด์  ํ๋ก์ ํธ๋ค๊ณผ ๋ฌ๋ฆฌ, 
๋ณ๋์ DTO๋ฅผ ๋ง๋ค์ด ๋ฐํํ์์ต๋๋ค.

Why? ์ DTO๋ฅผ ์จ์ผ๋ง ํ ๊น?
1. ํ์ด๋ธ ์ค๊ณ๋ฅผ ๋ธ์ถํ์ง ์๊ณ , ์ํฐํฐ ๋ด๋ถ ๊ตฌํ์ ์บก์ํ ํ  ์ ์์ต๋๋ค.
2. View์ ํ์ํ ๋ฐ์ดํฐ๋ฅผ ์ ๋ณํ  ์ ์์ต๋๋ค.
3. ์ํ์ฐธ์กฐ๊ฐ ์ผ์ด๋์ง ์๋๋ก ์๋ต DTO๋ฅผ ๋๋ ๊ฒ์ด ์์ ํฉ๋๋ค.
4. ๊ฐ ์์ฒญ์ ํ์ํ validation์ DTO์ ์ ์ํ๋ฉด, ์ํฐํฐ๋ฅผ ๋ชจ๋ธ๋ง๊ณผ ๋น์ฆ๋์ค ๋ก์ง์ ์ง์ค๋๋๋ก ๋ง๋ค ์ ์์ต๋๋ค.
๋ฑ๋ฑ

์ค๋ฌด๋ฅผ ๊ฒฝํํด๋ณธ ์ ์ด ์์ด ์๋ฟ์ง ์๋ ๋ถ๋ถ์ด์์ต๋๋ค.
ํ์ง๋ง ์ฑ๋ฅ ๋ฌธ์ ๋ฅผ ์ผ๊ธฐํ  ์ ์๋ ๊ฒ๋ค์ ๋ํด ๊ณต๋ถํด๋ณด์๊ณ , 
๐ก ๊ทธ ์ค '์ํฐํฐ๋ฅผ ์น์ ๋ธ์ถํด์๋ ์ ๋๋ค๋ ๊ฒ'์ ์๊ฒ ๋์์ต๋๋ค.
```

<details>
<summary>[์ด์  ์ํฉ] DTO์ ์กด์ฌ๋ฅผ ๋ชฐ๋๋ ์ง๋ ํ๋ก์ ํธ๋ค</summary>
<div markdown="1">

* Ex) ๋ชจ๋  ๊ฒ์๋ฌผ ์ถ๋ ฅ
* [Controller] : DTO๋ฅผ ์์ฑํ์ง ์๊ณ , Entity๋ฅผ ๋ฐ๋ก ๋ฐํํ๋ค.
```java
// ์ ์ฒด ๊ฒ์๋ฌผ ์ถ๋ ฅ
@RequestMapping("/job_index")
public String viewJobAllList(Model model) {

  // ๊ฒ์๋ฌผ Entity๋ฅผ ๊ทธ๋๋ก Serivce์ ์ ๋ฌํ๋ค.
  ArrayList<JobVO> jobList = jobService.listAllJob();
  model.addAttribute("jobList", jobList); // View Page์ Entity๋ฅผ ๋ฐ๋ก ์ ๋ฌํ๋ค.

  return "job/job_index";
}
```
</div>
</details>

<details>
<summary>[์ด๋ฒ ํ๋ก์ ํธ ์] DTO๊ฐ ์ ์ ์ฉ๋์ด์ผ ํ๋์ง ํ์ตํ๊ณ  ์ ์ฉ</summary>
<div markdown="1">

* โDTO๋ฅผ ์ ๋ง๋๋ ๊ฒ์ธ๊ฐ'์ ๋ํ ๊ณ ์ฐฐ
* Ex) ๋ชจ๋  ๊ฒ์๋ฌผ ์ถ๋ ฅ
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
   * @QueryProjection : Querydsl๋ก ๊ฒฐ๊ณผ ์กฐํ ์, MainItemDto ๊ฐ์ฒด๋ก ๋ฐ๋ก ๋ฐ์์ด
   * - DTO ํด๋์ค๋ก ๋ณํํ๋ ๊ณผ์  ์์ด ๋ฐ๋ก DTO ๊ฐ์ฒด๋ฅผ ๋ฝ์๋
   * - DTO ๊ธฐ๋ฐ์ผ๋ก ์์ฑ๋ QDTO ๊ฐ์ฒด์ ์์ฑ์๋ฅผ ์ฌ์ฉํ๋ ๊ฒ
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

    // ์ถ๋ ฅํ  ๊ฒ์๋ฌผ DTO๋ฅผ Service์ ์ ๋ฌํ๋ค.
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
<summary>๋๋์ </summary>
<div markdown="1">

- DTO๊ฐ ์์์๋ก ๊ตฌ์กฐ๊ฐ ๋จ์ํ๊ณ  ์ง๊ด์ ์ด์ด์ ์ดํด๊ฐ ์ฌ์ ๋ค.
- ํ์ง๋ง DTO๊ฐ ๋ง์์ง์๋ก ๊ตฌ์กฐ๊ฐ ๋ณต์กํด์ง๊ณ  DTO์ Entity ์ฌ์ด์ ๋ณํ, DTO์ Service์ ๊ต๋ฅ ๋ฑ์ด ์ดํดํ๊ธฐ ์ด๋ ค์์ก๋ค.
- ๋ฐ๋ผ์ RequestDTO์ ResponseDTO๋ก ๋ ์ธ๋ถํํด์ ๋๋๋ ค๋ฉด, DTO์ ๋ ๊น์ ์ดํด๊ฐ ํ์ํ๋ค.
- ๊ฐ์ฒด ์งํฅ ์ค๊ณ ์ญ์ ๋ ์ ๋๋ก ๋ ์ดํด์ ์ ์ฉ์ด ํ์ํ๋ค.

</div>
</details>

<br>

### 4. Test Code ์์ฑํ๊ธฐ
> ๋งค๋ฒ View Page๋ฅผ ํตํด ์๋ํ ๊ฒฐ๊ณผ๊ฐ ๋ง๋์ง ํ์ธ โ Test Code ์ ์ฉ

```text
๐ค ์ด์  ํ๋ก์ ํธ๋ค์์  
Test Code๋ฅผ ์์ฑํ์ง ์๊ณ , ์์ฑํ ์ฝ๋๊ฐ ์ ์์ ์ผ๋ก ๋์๊ฐ๋์ง 
๋งค๋ฒ View Page์์ ํ์ธ์ ํ์์ต๋๋ค.

ํ์ง๋ง Test Code๋ฅผ ์์ฑํ๋ฉด, ์ฝ๋์ ์ถ๊ฐ ๋๋ ๋ณ๊ฒฝ์ด ์์ ๊ฒฝ์ฐ 
๋ฌธ์ ๋ฅผ ๋น ๋ฅด๊ฒ ํ์ํ์ฌ ๊ฐ๋ฐ์ ์ ์ง๋ณด์์ฑ์ ์ฆ์ง์ํฌ ์ ์๋ค๋ ๊ฒ์ ์๊ฒ๋์์ต๋๋ค.

Why? ์ ํ์คํธ ์ฝ๋๋ฅผ ์์ฑํด์ผ ํ ๊น?
1. ๋จ์ ํ์คํธ๋ ๊ฐ๋ฐ ์ด๊ธฐ์ ๋ฌธ์ ๋ฅผ ๋ฐ๊ฒฌํ๊ฒ ๋์์ค๋๋ค.
2. ๋จ์ ํ์คํธ๋ก ์ธํด ์ฝ๋๋ฅผ ๋ฆฌํฉํ ๋งํ  ์ ๊ธฐ์กด ๊ธฐ๋ฅ์ด ์ฌ๋ฐ๋ฅด๊ฒ ์๋ํ๋์ง ํ์ธํ  ์ ์์ต๋๋ค.
3. ๋จ์ ํ์คํธ๋ ๊ธฐ๋ฅ์ ๋ํ ๋ถํ์ค์ฑ์ ๊ฐ์์ํฌ ์ ์์ต๋๋ค.
4. ๋จ์ ํ์คํธ ์์ฒด๊ฐ ์์คํ ๋ฌธ์๋ก ์ฌ์ฉ๋  ์ ์์ต๋๋ค.
๋ฑ๋ฑ

๋ฐ๋ผ์ ์ด๋ฒ ํ๋ก์ ํธ๋ฅผ ํตํด 
๐ก 'Test Code๋ฅผ ์์ฑํ๊ณ , ํ์ View Page ์ฝ๋๋ฅผ ์์ฑ'ํ์ต๋๋ค.
```

<details>
<summary>[์ด์  ์ํฉ] Test Code์ ์กด์ฌ ์์ฒด๋ฅผ ๋ชฐ๋๋ ์ง๋ ํ๋ก์ ํธ๋ค</summary>
<div markdown="1">

* Ex) Test View Page๋ฅผ ์์ฑํด ์๋ํ ๊ฒฐ๊ณผ๊ฐ ๋ง๊ฒ ๋์ค๋์ง ํ์ธ
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
<summary>[์ด๋ฒ ํ๋ก์ ํธ ์] ์ฝ๋์ ์ข ๋ ์ง์คํ๊ธฐ ์ํด Test Code๋ฅผ ์ ์ฉ</summary>
<div markdown="1">

* Ex 1) ์ค๋ณต ํ์ ๊ฐ์ ํ์คํธ
```java
// ์์์ ํ์ ์ ๋ณด ์์ฑ
public Member createMember() {
    MemberFormDto memberFormDto = new MemberFormDto();
    memberFormDto.setEmail("test@email.com");
    memberFormDto.setName("๊น๊ธธ๋");
    memberFormDto.setAddress("๊ฒฝ๊ธฐ๋");
    memberFormDto.setPassword("1234");
    return Member.createMember(memberFormDto, passwordEncoder);
}

// ์ค๋ณต ํ์ ๊ฐ์ ํ์คํธ
@Test
@DisplayName("์ค๋ณต ํ์ ๊ฐ์ ํ์คํธ")
public void saveDuplicateMemberTest(){
    Member member1 = createMember();
    Member member2 = createMember();
    memberService.saveMember(member1);
    Throwable e = assertThrows(AppException.class, () -> {
    memberService.saveMember(member2);});

    // ๋ฐ์์ํจ ์์ธ์ฒ๋ฆฌ ๋ฉ์ธ์ง์ ์ผ์นํ๋์ง ํ์ธํ๋ค.
    assertEquals("๊น๊ธธ๋์ ์ด๋ฏธ ์์ต๋๋ค.", e.getMessage());
}
```

* Ex 2) ๋ง์ดํ์ด์ง ์ค๋ณต ๊ฒ์๋ฌผ ์ ์ฅ ํ์คํธ
```java
@Test
@DisplayName("๋ง์ดํ์ด์ง ์ค๋ณต ๋ ์ํผ ์ ์ฅ ํ์คํธ")
public void saveDuplicateCartTest() {
    Recipe recipe = saveRecipe();
    Member member = saveMember();

    CartRecipeDto cartRecipeDto = new CartRecipeDto();
    cartRecipeDto.setRecipeId(recipe.getId());

    Long cartRecipeId = cartService.addCart(cartRecipeDto, member.getEmail());
    CartRecipe cartRecipe = cartRecipeRepository.findById(cartRecipeId)
            .orElseThrow(EntityNotFoundException::new);

		// ๋์ผํ ๊ฒ์๋ฌผ์ ํ๋ฒ ๋ ์ ์ฅํ๋ค.
    // ๋ฐ์์ํจ ์์ธ์ฒ๋ฆฌ ๋ฉ์ธ์ง์ ์ผ์นํ๋์ง ํ์ธํ๋ค.
    Throwable e = assertThrows(AppException.class, () -> {
        cartService.addCart(cartRecipeDto, member.getEmail());});
    assertEquals(recipe.getRecipeName() + "์ ์ด๋ฏธ ์ ์ฅ๋์ด์์ต๋๋ค.", e.getMessage());
}
```
</div>
</details>

<details>
<summary>๋๋์ </summary>
<div markdown="1">

- Test Code๋ ์ ์ธ๊ณ์๋ค. View๊ฐ ์์ด๋ ์ฝ๋๊ฐ ๋ง๋์ง ํ์ธํ  ์ ์๋ค๋...
- ํ์ง๋ง ๋ด๊ฐ ์ง  Test Code์ ์ค๋ฅ๋ก ๋ง๊ฒ ์ฝ๋๋ฅผ ์งฐ์ง๋ง ํ์คํธ์ฝ๋๊ฐ ์คํจํ๋ค๋์ง, ํ๋ฆฐ ์ฝ๋๋ฅผ ์งฐ์ง๋ง ํ์คํธ์ฝ๋๊ฐ ์ฑ๊ณตํ๋ค๋์ง... ์ด๋ฐ ํ์๋ค์ด ๋ฐ๋ณต๋ผ์ ์์ง๊น์ง๋ View์ ์ต์ข ํ์ธ์ ๋ฐ๋๋ค.
- Test Code์ ๋ํ ๋ ๊น์ ์ดํด์ ํ์ต์ ํตํด ๊ตฌํํ๊ณ ์ ํ๋ ๊ธฐ๋ฅ์ ํ์คํธ์ฝ๋๋ฅผ ์์ฑํ๊ณ , ๊ทธ๋ฅผ ํตํ ํ๋ก์ ํธ ์งํ ๋ฐฉ์์ ์ ์ฉ์์ผ๋ณด๊ณ  ์ถ๋ค.

</div>
</details>

<br>
<br>
<br>

## ๐ต๐ป ํ๊ธฐ & ์์ผ๋ก ๊ฐ์ ํ  ๋ด์ฉ
```text
* ํ ์ค ์ ๋ฆฌ : ์ด๋ ค์ธ์๋ก ๊ธฐ๋ณธ์ ์ถฉ์คํด์ผ ํ๋ค.

1. ์ฒ์๋ถํฐ ๋ง์ ๊ฒ์ ํ๋ ค ํ์ ๋ ์์ด ๋ง๋งํ์ต๋๋ค.
ํ์ง๋ง ์ด๋ ค์ธ์๋ก ๊ธฐ๋ณธ์ผ๋ก ๋์๊ฐ์๋ ์ฌ์ค์ ๋ช์ฌํ๊ณ , 
์์ ๊ธฐ๋ฅ๋ถํฐ ๋ง๋ค์ด๋๊ฐ๋ ๊ฒ์ ์ ํํ์ต๋๋ค.
- ํ์ ๊ฐ์ โ ํ์์ด ๋ฑ๋กํ๋ ๊ฒ์๋ฌผ โ ๊ฒ์๋ฌผ ์ด๋ฏธ์ง ๋ฑ๋ก โ ๊ฒ์๋ฌผ ๋ง์ดํ์ด์ง ์ ์ฅ
- ์ดํ ์์ธ ์ํฉ์ด ๋ฐ์ํ๋ ๊ฒฝ์ฐ๋ฅผ ์๊ฐํด๋ณด๊ณ , ํ๋์ฉ ์ ์ฉ์์ผ๋ณด์์ต๋๋ค.

2. JPA๋ฅผ ์ฌ์ฉํ๋ ค๋ฉด, ๊ฐ์ฒด์งํฅ์ ๋ํ ๊น์ ์ดํด๊ฐ ํ์ํ๋ค๋ ๊ฒ์ ์๊ฒ๋์์ต๋๋ค.
๊ฐ์ฒด์งํฅ์ ์ ๋ง ์ด๋ ต์ง๋ง, ๋งค์ฐ ์ค์ํ ๋ด์ฉ์ด๊ณ  ๊ทผ๋ณธ์๋๋ค.

3. ํ๋ก์ ํธ์ ๋ํ ์ถ๊ฐ์ ์ธ ์๊ฐ๋ค์, ๊ณง ๋์ ๋ถ์กฑํ ๋ถ๋ถ์ ์ฑ์๊ฐ๋ ๊ณผ์ ์ด๋ค.
- ๊ธฐ๋ฅ์ ์ ์ฒด์ ์ธ ํฐ ํ์ ๋ง๋ค์ด ๋๊ณ , ์์ธ ๋ฐ์๊ณผ ๊ตฌ์กฐ์ ๋ํ ์๊ฐ์ ํ๋ฉด์ 
ํ๋ก์ ํธ์ ๋ถ์กฑํ ๋ถ๋ถ๋ค์ด ๋ณด์์ต๋๋ค.
- ๊ทธ ๋ถ๋ถ์ ๊ฐ์ ํด๋๊ฐ๋ ๊ณผ์ ์์  ๋ ๋ค๋ฅธ ๋ถ์กฑํ ์ ๋ค์ด ๋ณด์ด๋ ๊ฒ์ด ๋ฐ๋ณต๋์์ต๋๋ค.
- ๊ฐ๋ฐ์ ์ฒ์ ์์ํ์ ๋ ๋ถ์กฑํ ๋ถ๋ถ์ ๋ง์ฃผํ๋ ๊ฒ์ด ๋๋ ค์ ์ง๋ง, 
์ง๊ธ์ ์ฑ์ฅํด๋๊ฐ๋ ๊ณผ์ ์ด๋ผ๋ ์๊ฐ์ผ๋ก ๋ถ๋ชํ๋ณด๊ณ  ์์ต๋๋ค

5. QueryDSL์ด ์ด๋ ต๊ณ  ์๋ฟ์ง ์๋ ๊ฐ๋์ด์ด์์ต๋๋ค.
- SQLMapper๋ก ๊ฒ์ ๊ธฐ๋ฅ์ ๋ง๋ค์์ ๋, ์ง๊ด์ ์ด์ด์ ์ดํด๊ฐ ๋น ๋ฅด๊ฒ ๋์๋๋ฐ, 
Querydsl์ ๋งค์ฐ ์ด๋ ต๊ฒ ๋ค๊ฐ์์ต๋๋ค.
- Java ์ฝ๋๋ฅผ ์์ฑํ๋ฏ์ด ์ฟผ๋ฆฌ๋ฌธ์ ์์ฑํ๋ ๊ฒ์ด ์ ์ธ๊ณ์์ต๋๋ค.

6. ๋ ๋ง์ Test Code์ ํ์ต์ด ํ์ํ๋ค๋ ๊ฑธ ๋๋์๋ก ์์ฌ์ ์ต๋๋ค.
- ์ค์ค๋ก ์์ฑํ Test Code์ ๋ก์ง์ด ํ๋ ค, ํ๋ฆฐ ํ์คํธ์ผ์ด์ค๋ฅผ ๋ง๋ค์ด๋ ํต๊ณผ๊ฐ ๋๋ ํ์์ด ๋ํ๋ฌ์ต๋๋ค.
- Test Code์ ๋ํ ๋ ๊น์ ์ดํด์ ํ์ต์ ํตํด ๊ตฌํํ๊ณ ์ ํ๋ ๊ธฐ๋ฅ์ ํ์คํธ์ฝ๋๋ฅผ ์์ฑํ๊ณ , 
๊ทธ์ ๋ํ ํ๋ก์ ํธ ์งํ ๋ฐฉ์์ ์ ์ฉ์์ผ๋ณด๊ณ  ์ถ์ต๋๋ค๋ค.


๋ ์์ธํ ๋ด์ฉ์ Notion์ ์์ต๋๋ค.

```

<br>
<br>

---

<br>
<br>

๋ ์์ธํ ๋ด์ฉ์ Notion์ ์์ต๋๋ค.