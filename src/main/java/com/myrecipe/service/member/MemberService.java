package com.myrecipe.service.member;

import com.myrecipe.dto.MemberFormDto;
import com.myrecipe.entity.Member;
import com.myrecipe.exception.AppException;
import com.myrecipe.exception.ErrorCode;
import com.myrecipe.exception.member.MemberException;
import com.myrecipe.exception.member.MemberExceptionType;
import com.myrecipe.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


/**
 * UserDetailsService : 데이터베이스에서 회원 정보를 가져옴.
 * loadUserByUsername() : 회원 정보를 조회하여 사용자 정보와 권한을 갖는 UserDetails 인터페이스 반환
 * */
@Transactional
@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {

    public final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    /**
     * 회원가입 중복 검사
     * 이메일 중복 불가능
     * */
    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail()); // 이메일로 찾은 회원을 Member에 담는다.

        if(findMember != null) {
            throw new MemberException(MemberExceptionType.ALREADY_EXIST_USERNAME);
        }
    }


    /**
     * UserDetails : 스프링 시큐리티에서 회원의 정보를 담기 위해 사용하는 인터페이스
     * */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }

    // /////////////////////////////////////////////////////////////////////
    /**
     * 회원 정보 수정
     * */
    public Long updateMember(Long memberId, MemberFormDto memberFormDto) {

        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(EntityNotFoundException::new);

        if(findMember == null) {
            throw new MemberException(MemberExceptionType.NOT_FOUND_MEMBER);
        }

        String password = passwordEncoder.encode(findMember.getPassword());

        findMember.updateMember(memberFormDto, password);

        return findMember.getId();
    }
    
    /**
     * 회원 정보 불러오기
     * */
    @Transactional(readOnly = true)
    public MemberFormDto getMemberDetail(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER)
        );

        MemberFormDto memberFormDto = MemberFormDto.of(member);

        return memberFormDto;
    }
    
}
