package com.kh.finalPrjPm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

// 장바구니 엔티티 생성
@Entity
@Getter @Setter @ToString
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cartName;

    @OneToOne // 회원엔티티와 일대일 매칭
    @JoinColumn(name="member_id")
    private Member member;
}
