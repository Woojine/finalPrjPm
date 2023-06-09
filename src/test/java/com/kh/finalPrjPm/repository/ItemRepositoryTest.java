package com.kh.finalPrjPm.repository;

import com.kh.finalPrjPm.constant.ItemSellStatus;
import com.kh.finalPrjPm.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품" +i);
            item.setPrice(10000 + i*10);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
            System.out.println(savedItem.toString());
        }
    }
    @Test@DisplayName("상품 조회 테스트")
    public void findAllTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findAll();
        for(Item e : itemList) {
            System.out.print(e.toString());
        }
    }
    @Test@DisplayName("상품 개별 조회 테스트")
    public void findByItemTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품5");
        for(Item e : itemList) {
            System.out.print(e.toString());
        }
    }
    @Test
    @DisplayName("상품명 OR 상품 상세 설명")
    public void findByItemNmOrItemDetailTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품5", "테스트 상품 상세 설명7");
        for(Item e : itemList) {
            System.out.println("결과 : " +e.toString());
        }
    }
    @Test
    @DisplayName("입력 받은 가격보다 싼 상품 출력")
    public void findByPriceLessThanTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceLessThan(10045);
        for(Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }
    @Test
    @DisplayName("입력 받은 가격보다 싼 상품을 찾아서 내림차순 정렬")
    public void findByPriceLessThanOrderByPriceDescTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10045);
        for(Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }
    @Test
    @DisplayName("입력 받은 가격의 범위 검색")
    public void findByPriceBetweenTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByPriceBetween(10025, 10085);
        for(Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }
    @Test
    @DisplayName("포함된 문자열 검색")
    public void findByItemNmContainingTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNmContaining("상품3");
        for(Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }
    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByItemDetailTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemDetailByNative("상세 설명6");
        for(Item e : itemList) {
            System.out.println("결과 : " + e.toString());
        }
    }
}