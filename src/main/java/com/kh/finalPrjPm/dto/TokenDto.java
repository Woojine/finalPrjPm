package com.kh.finalPrjPm.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    private String grantType; // 토큰의 유형
    private String accessToken; // 실제 사용될 토큰
    private Long tokenExpiresIn; // 만료 시간
}
