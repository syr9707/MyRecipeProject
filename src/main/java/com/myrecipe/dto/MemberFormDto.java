package com.myrecipe.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * 회원 가입으로부터 넘어오는 가입정보를 담을 dto
 * */
/**
 * VO(Value Object) vs DTO
 *   * VO는 DTO와 동일한 개념이지만 read only 속성을 갖는다.
 *   * VO는 특정한 비즈니스 값을 담는 객체이고, DTO는 Layer간의 통신 용도로 오고가는 객체를 말한다.
 * */
@Setter
@Getter
public class MemberFormDto {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
    private String password;

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;

}
