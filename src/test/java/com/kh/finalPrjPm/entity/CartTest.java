package com.kh.finalPrjPm.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링 컨텍스트를 로드하여 테스트 환경 설정
@Transactional // 데이터베이스의 논리적인 작업 단위, 모두가 모든 작업이 성공하지 않으면 롤백, 성공해도 롤백
@Slf4j // 로깅 테이터를 처리하기 위해사용
@TestPropertySource(locations = "classpath:application-test.properties")
class CartTest {
    @Autowired // 스프링 컨테이너에서 해당 빈으로 등록된 객체를 의존성 주입 받음

}