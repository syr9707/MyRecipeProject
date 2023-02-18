package com.myrecipe.repository;

import com.myrecipe.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 이메일로 중복 검사
    Member findByEmail(String email);

}
