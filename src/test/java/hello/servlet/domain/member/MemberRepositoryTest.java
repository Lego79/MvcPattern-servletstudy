package hello.servlet.domain.member;


import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*; //스태틱임포트가 자동으로 드감

public class MemberRepositoryTest {

//    MemberRepository memberRepository = new MemberRepository(); //singletion 이기 때문에[ new 가 사용 안됨

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach //테스트 끝나면 테스트 클리어
   void afterEach() {
        memberRepository.clearStore(); // 이 기능이 없으면 순서가 보장이 안됨

   }

   @Test

    void save() {
        //given
       Member member = new Member("ToTo", 20);

       //when
       Member savedMember = memberRepository.save(member);

       //then
       Member findMember = memberRepository.findById(savedMember.getId());
       assertThat(findMember).isEqualTo(savedMember);
   }

   @Test
    void findAll() {
        //given
       Member member1 = new Member("member1", 20);
       Member member2 = new Member("member2", 24);

       //whwen

       memberRepository.save(member1);
       memberRepository.save(member2);


       List<Member> result = memberRepository.findAll();


       //then
       assertThat(result.size()).isEqualTo(2);
       assertThat(result).contains(member1, member2);





   }


}
