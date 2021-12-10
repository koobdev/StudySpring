package com.example.firstspring.service;

import com.example.firstspring.domain.Member;
import com.example.firstspring.repository.MemberRepository;
import com.example.firstspring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import java.nio.channels.IllegalSelectorException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository repository;
    MemberService memberService;

    @BeforeEach
    void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    void afterEach(){
        repository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member1 = new Member();
        member1.setName("member1");

        Member member2 = new Member();
        member2.setName("member1");
        
        // when
        String name = memberService.join(member1);

        // then
        assertThat(name).isEqualTo(member1.getName());
    }

    @Test
    void 중복_회원_검증(){
        // given
        Member member1 = new Member();
        member1.setName("member1");

        Member member2 = new Member();
        member2.setName("member1");

        // when
        memberService.join(member1);

        // then
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        /*try {
            memberService.join(member2);
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
        }*/
    }

    @Test
    void findMembers() {
        Member member1 = new Member();
        member1.setName("member1");

        Member member2 = new Member();
        member2.setName("member2");
    }

    @Test
    void findMember() {
    }
}