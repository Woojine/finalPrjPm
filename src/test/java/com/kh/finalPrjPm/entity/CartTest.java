package com.kh.finalPrjPm.entity;

import com.kh.finalPrjPm.repository.CartRepository;
import com.kh.finalPrjPm.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링 컨텍스트를 로드하여 테스트 환경 설정
@Transactional // 데이터베이스의 논리적인 작업 단위, 모두가 모든 작업이 성공하지 않으면 롤백, 성공해도 롤백
@Slf4j // 로깅 테이터를 처리하기 위해사용
@TestPropertySource(locations = "classpath:application-test.properties")
class CartTest {
    @Autowired // 스프링 컨테이너에서 해당 빈으로 등록된 객체를 의존성 주입 받음
    CartRepository cartRepository;
    @Autowired
    MemberRepository memberRepository;
    @PersistenceContext // JPA의 EntityManager를 사용하기 위해서 주입 받음
    EntityManager em;
    // 회원 엔티티 생성
    public Member createMemberInfo() {
        Member member = new Member();
        member.setUserID("jks2024");
        member.setPassword("sphb8250");
        member.setName("곰돌이사육사");
        member.setEmail("jks2024@gmail.com");
        member.setJoinTime(LocalDateTime.now());
        return member;
    }
    @Test
    @DisplayName("장바구니 회원 매핑 조회 테스트")
    public void findCartAndMemberTest() {
        Member member = createMemberInfo();
        memberRepository.save(member);
        Cart cart = new Cart();
        cart.setCartName("오늘의 구매 목록");
        cart.setMember(member);
        cartRepository.save(cart);

        em.flush(); // 트랜잭션이 끝날 때 데이터베이스에 반영
        em.clear(); // 영속성 컨텍스트를 비움

        Cart saveCart = cartRepository.findById(cart.getId()).orElseThrow(EntityNotFoundException::new);
        System.out.println("회원 아이디 : " + member.getUserID());
        System.out.println("장바구니 회원 아이디 : " + cart.getMember().getUserID());
    }

}