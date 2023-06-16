package com.kh.finalPrjPm.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ItemDto {
    private String name;
    private int price;
    private String detail;
    private int stock;
    private LocalDateTime regTime;
}
