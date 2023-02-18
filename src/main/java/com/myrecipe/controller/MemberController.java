package com.myrecipe.controller;

import com.myrecipe.dto.MemberFormDto;
import com.myrecipe.entity.Member;
import com.myrecipe.exception.AppException;
import com.myrecipe.exception.member.MemberException;
import com.myrecipe.exception.member.MemberExceptionType;
import com.myrecipe.repository.MemberRepository;
import com.myrecipe.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        } catch (MemberException e){
            model.addAttribute("errorMessage", e.getExceptionType().getErrorMessage());
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

        try {
            MemberFormDto memberFormDto = memberService.getMemberDetail(memberId);
            model.addAttribute("memberFormDto", memberFormDto);
            model.addAttribute("memberId", memberId);
        } catch (MemberException e){
            model.addAttribute("errorMessage", e.getExceptionType().getErrorMessage());
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
