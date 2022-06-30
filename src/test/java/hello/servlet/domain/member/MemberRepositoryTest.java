package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStroe();
    }

    @Test
    void save() {
        Member member = new Member("member1", 20);

        Member saveMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(saveMember.getId());

        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void findAll() throws Exception {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> findAll = memberRepository.findAll();

        //then
        assertThat(findAll.size()).isEqualTo(2);
        assertThat(findAll).contains(member1, member2);
    }
}