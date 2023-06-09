package com.kh.finalPrjPm.repository;

import com.kh.finalPrjPm.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// JpaRepository는 첫 번째에는 엔티티 타입 클래스를 넣어주고, 두 번째는 기본 키
// 기본적인 CRUD 및 페이징 처리를 위한 메소드가 정의 되어 있어 사용 가능
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemNm(String itemNm);
    // OR 조건
    List<Item> findByItemNmOrItemDetail(String itemsNm, String itemDetail);
    // LessThan : 입력 받은 가격보다 작은 상품을 반환 받음
    List<Item> findByPriceLessThan(Integer price);
    // OrderBy : OrderBy + 속성명 + Asc or Desc
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
    // Between : 범위 검색
    List<Item> findByPriceBetween(Integer min, Integer max);
    // 부분 문자열 검색
    List<Item> findByItemNmContaining(String keyword);
    // JPQL 쿼리 작성 하기
    @Query(value = "select * from item where item_detail like %:itemDetail% order by price desc",
    nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}
