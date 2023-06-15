package com.kh.finalPrjPm.service;


import com.kh.finalPrjPm.constant.ItemSellStatus;
import com.kh.finalPrjPm.dto.ItemDto;
import com.kh.finalPrjPm.entity.Item;
import com.kh.finalPrjPm.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    // 상품 생성
    public boolean createItem(String name, int price, String detail, ItemSellStatus status, int stock) {
        Item item = new Item();
        item.setItemNm(name);
        item.setPrice(price);
        item.setItemDetail(detail);
        item.setItemSellStatus(status);
        item.setStockNumber(stock);
        Item saveItem = itemRepository.save(item);
        log.info("저장된 상품 이름 : " + saveItem.getItemNm());
        return true;
    }
    // 상품 조회
    public List<ItemDto> getItemList() {
        List<Item> items = itemRepository.findAll();
        List<ItemDto> itemDtos = new ArrayList<>();
        for(Item item : items) {
            ItemDto itemDto = new ItemDto();
            itemDto.setName(item.getItemNm());
            itemDto.setPrice(item.getPrice());
            itemDto.setDetail(item.getItemDetail());
            itemDto.setStock(item.getStockNumber());
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
}