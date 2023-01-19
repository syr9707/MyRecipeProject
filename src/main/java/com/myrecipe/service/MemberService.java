package com.myrecipe.service;

import com.myrecipe.entity.Member;
import com.myrecipe.exception.AppException;
import com.myrecipe.exception.ErrorCode;
import com.myrecipe.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * UserDetailsService : 데이터베이스에서 회원 정보를 가져옴.
 * loadUserByUsername() : 회원 정보를 조회하여 사용자 정보와 권한을 갖는 UserDetails 인터페이스 반환
 * */
@Transactional
@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {

    public final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null) {
//            throw new IllegalStateException("이미 가입된 회원입니다.");
            throw new AppException(ErrorCode.MEMBERNAME_DUPLICATED, findMember.getName() + "은 이미 있습니다.");
        }
    }


    /**
     * UserDetails : 스프링 시큐리티에서 회원의 정보를 담기 위해 사용하는 인터페이스
     * */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);

        if(member == null){
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
