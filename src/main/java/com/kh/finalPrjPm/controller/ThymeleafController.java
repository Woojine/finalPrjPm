package com.kh.finalPrjPm.controller;

import com.kh.finalPrjPm.dto.ItemDto;
import com.kh.finalPrjPm.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf1")
public class ThymeleafController {
    @GetMapping("/item")
    public String thymeleafItem(Model model) {
        ItemDto itemDto = new ItemDto();
        itemDto.setName("LG 오브젝 에어컨");
        itemDto.setDetail("LG 23년형 에어컨 입니다.");
        itemDto.setPrice(100000);
        itemDto.setRegTime(LocalDateTime.now());
        model.addAttribute("itemDto", itemDto);
        return "thymeleaf/thymeleafItem";
    }
    @GetMapping("/item-list")
    public String thymeleafItemList(Model model) {
        List<ItemDto> itemDtoList = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setName("LG 오브젝 에어컨");
            itemDto.setDetail("LG 23년형 에어컨 입니다.");
            itemDto.setPrice(100000);
            itemDto.setRegTime(LocalDateTime.now());
            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleaf/thymeleafItemList";
    }
    @GetMapping("/link-move")
    public String thymeleafLinkMove() {
        return "thymeleaf/thymeleafLinkMove";
    }
    @GetMapping("/link-value")
    public String thymeleafLinkValue(String param1, String param2, Model model) {
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thymeleaf/thymeleafLinkParam";
    }
}
