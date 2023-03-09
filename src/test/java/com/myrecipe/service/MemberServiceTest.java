package com.myrecipe.service;

import com.myrecipe.dto.MemberFormDto;
import com.myrecipe.entity.Member;
import com.myrecipe.exception.AppException;
import com.myrecipe.exception.member.MemberException;
import com.myrecipe.exception.member.MemberExceptionType;
import com.myrecipe.repository.MemberRepository;
import com.myrecipe.service.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    private void clear(){
        em.flush();
        em.clear();
    }

    public Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("test@email.com");
        memberFormDto.setName("김길동");
        memberFormDto.setAddress("경기도");
        memberFormDto.setPassword("1234");
        return Member.createMember(memberFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);
        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAddress(), savedMember.getAddress());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getRole(), savedMember.getRole());
    }

//    @Test
//    @DisplayName("중복 회원 가입 테스트")
//    public void saveDuplicateMemberTest(){
//        Member member1 = createMember();
//        Member member2 = createMember();
//        memberService.saveMember(member1);
//        Throwable e = assertThrows(AppException.class, () -> {
//            memberService.saveMember(member2);});
//        assertEquals("김길동은 이미 있습니다.", e.getMessage());
//    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMemberTest(){
        Member member1 = createMember();
        Member member2 = createMember();
        memberService.saveMember(member1);

        assertThat(assertThrows(MemberException.class,
                () -> memberService.saveMember(member2)).getExceptionType()).isEqualTo(MemberExceptionType.ALREADY_EXIST_USERNAME);

    }

    @Test
    @DisplayName("회원가입 실패 - 필드가 없음")
    public void saveMemberFailTest() {
        // given
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("test@email.com");
//        memberFormDto.setName(null);
        memberFormDto.setAddress("경기도");
        memberFormDto.setPassword("1234");
        Member member = Member.createMember(memberFormDto, passwordEncoder);

//        memberService.saveMember(member);

        // when, then
        assertThat(memberRepository.findAll().size()).isEqualTo(0);
        assertThrows(Exception.class, () -> memberService.saveMember(member));
    }

    @Test
    @DisplayName("회원정보 수정 성공 - 이름 변경")
    public void updateMember() {
        // given
        Member member = createMember();
        memberService.saveMember(member);

        Member findMember = memberRepository.findById(member.getId()).orElseThrow(
                () -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER)
        );

        // when
        String updateName = "변경된이름";
        findMember.setName(updateName);

        MemberFormDto memberFormDto = MemberFormDto.of(member);
        memberService.updateMember(member.getId(), memberFormDto);

        // then
        Member updateMember = memberRepository.findById(findMember.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원 없습니다. userId = " + findMember.getId()));

        assertThat(updateMember).isSameAs(findMember);
        assertThat(updateMember.getName()).isEqualTo(updateName);
    }

}