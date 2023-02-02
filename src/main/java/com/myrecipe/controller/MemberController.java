package com.myrecipe.controller;

import com.myrecipe.dto.MemberFormDto;
import com.myrecipe.entity.Member;
import com.myrecipe.exception.AppException;
import com.myrecipe.repository.MemberRepository;
import com.myrecipe.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/members")
@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    public final MemberRepository memberRepository;

    @GetMapping("/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }

    @PostMapping("/new")
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "member/memberForm";
        }

        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (AppException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String loginMember(){
        return "/member/memberLoginForm";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "/member/memberLoginForm";
    }

    // //////////////////////////////////////////////////////////////

    @GetMapping(value = "/update/{memberId}")
    public String memberUpdateForm(@PathVariable("memberId") Long memberId, Model model) {
//        memberId = Long.parseLong(principal.getName());

//        memberFormDto = memberRepository.findByEmail(memberId);

        try {
            MemberFormDto memberFormDto = memberService.getMemberDetail(memberId);
            model.addAttribute("memberFormDto", memberFormDto);
            model.addAttribute("memberId", memberId);
        } catch (IllegalArgumentException e){
            model.addAttribute("errorMessage", "존재하지 않는 회원 입니다.");
            model.addAttribute("memberFormDto", new MemberFormDto());
            return "member/memberForm";
        }

        return "member/memberFormUpdate";
    }


    @PutMapping(value = "/update/{memberId}")
    public String update(@Valid MemberFormDto memberFormDto,
                         BindingResult bindingResult, Model model, @PathVariable("memberId") Long memberId) {

        if(bindingResult.hasErrors()) {
            return "member/memberFormUpdate";
        }

        try {
            memberService.updateMember(memberId, memberFormDto);
//            model.addAttribute("memberId", memberId);
        } catch (Exception e){
            model.addAttribute("errorMessage", "회원정보 수정 중 에러가 발생했습니다.");
            return "member/memberForm";
        }

        return "redirect:/";
    }

}
