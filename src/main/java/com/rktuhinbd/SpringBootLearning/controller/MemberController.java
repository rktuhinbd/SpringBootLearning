package com.rktuhinbd.SpringBootLearning.controller;

import com.rktuhinbd.SpringBootLearning.entity.Member;
import com.rktuhinbd.SpringBootLearning.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping(path = "{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PostMapping
    public Boolean addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @PutMapping(path = "{id}")
    public String updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }

    @DeleteMapping(path = "{id}")
    public String deleteMember(@PathVariable Long id) {
        return memberService.deleteMember(id);
    }
}
