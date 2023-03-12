package com.myrecipe.entity;

import com.myrecipe.constant.Role;
import com.myrecipe.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@ToString
@Setter
@Getter
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.ADMIN);
        return member;
    }

    // /////////////////////////////////////////////////////////////////
    // 회원 정보 수정
//    public void updateMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
//        this.name = memberFormDto.getName();
//        this.email = memberFormDto.getEmail();
//        this.password = passwordEncoder.encode(memberFormDto.getPassword());
//        this.address = memberFormDto.getAddress();
//    }

    public void updateMember(MemberFormDto memberFormDto, String password) {
        this.name = memberFormDto.getName();
        this.email = memberFormDto.getEmail();
        this.password = password;
        this.address = memberFormDto.getAddress();
    }

}
