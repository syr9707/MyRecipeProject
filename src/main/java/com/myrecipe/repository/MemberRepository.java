package com.myrecipe.repository;

import com.myrecipe.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 이메일로 중복 검사
    Member findByEmail(String email);

    // ////////////////////////////////////////
//    Member findByMemberId(Long id);

}
