package shopping.member.application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shopping.member.domain.Member;
import shopping.member.domain.MemberCreate;

class MemberServiceTest {
    @DisplayName("이미 등록된 이메일인 경우 예외를 발생시킨다.")
    @Test
    void register() {
        // given
        String duplicatedEmail = "email@email.com";
        MemberRepository memberRepository = new TestMemberRepository();
        memberRepository.save(Member.from(new MemberCreate(duplicatedEmail, "password")));
        MemberService memberService = new MemberService(memberRepository);

        // when
        MemberCreate newMemberCreate = new MemberCreate(duplicatedEmail, "password");
        assertThatThrownBy(() -> memberService.register(newMemberCreate))
                .isInstanceOf(AlreadyRegisteredEmailException.class);
    }
}