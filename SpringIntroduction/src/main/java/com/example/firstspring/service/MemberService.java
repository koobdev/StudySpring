package com.example.firstspring.service;

import com.example.firstspring.domain.Member;
import com.example.firstspring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    // DI
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // 회원가입
    public String join(Member member){
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });

        return repository.save(member).getName();
    }


    // 전체 회원 찾기
    public List<Member> findMembers(){
        return repository.findAll();
    }

    // 회원 한명찾기
    public Optional<Member> findMember(String name){
        return repository.findByName(name);
    }
}
