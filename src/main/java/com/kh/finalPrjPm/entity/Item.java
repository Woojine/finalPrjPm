package com.kh.finalPrjPm.entity;


import com.kh.finalPrjPm.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity // JPA에 Entity 클래스 임을 지정 합니다. Entity 클래스는 반드시 기본키를 가져야 함
@Getter @Setter @ToString
public class Item {
    @Id // 해당 필드가 기본키임을 지정
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Primary Key

    @Column(nullable = false, length = 50)
    private String itemNm; // 상품명

    @Column(nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고 수량

    @Lob
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private LocalDateTime regTime; // 등록 시간


    private LocalDateTime updateTime; // 수정 시간

}
