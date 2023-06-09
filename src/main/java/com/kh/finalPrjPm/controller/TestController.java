package com.kh.finalPrjPm.controller;

import com.kh.finalPrjPm.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // JSON 객체 타입으로 정보를 반환
@RequestMapping("api")
public class TestController {
    @RequestMapping(value = "/hello")
    public String getHello() {
        return "Hello, Spring Boot !!!!";
    }
    @GetMapping("/variable1/{variable}")
    // URL 주소에서 변수를 받을 때 사용
    public String getVariable(@PathVariable String variable) {
        return variable;
    }
    // @RequestParam : URL에서 '?'를 기준으로 우측에 '{키}={값}' 형태로 구성된 요청을 전송
    @GetMapping("/request1")
    public String getRequestParam(
            @RequestParam String user,
            @RequestParam String name,
            @RequestParam String email) {
        return user + " " + name + " " + email;
    }
    @GetMapping("/members")
    public List<Map<String, Object>> memberList() {
        List<Map<String, Object>> members = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            Map<String, Object> member = new HashMap<>();
            member.put("id", i);
            member.put("name", i + "번 개발자");
            member.put("age", 10 + i);
            members.add(member);
        }
        return members;
    }
    @GetMapping("/members2")
    public List<MemberDto> memberList2() {
        List<MemberDto> members = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            MemberDto member = new MemberDto();
            member.setUser("sun65568" + i);
            member.setName("정우진" + i);
            member.setPwd("as7300" + i);
            member.setEmail("sun65568@naver.com" + i);
            members.add(member);
        }
        return members;
    }
    @GetMapping("/members3")
    public ResponseEntity<List<MemberDto>> memberList3() {
        List<MemberDto> members = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            MemberDto member = new MemberDto();
            member.setUser("sun65568" + i);
            member.setName("정우진" + i);
            member.setPwd("as7300" + i);
            member.setEmail("sun65568@naver.com" + i);
            members.add(member);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
    @PostMapping("/member_reg")
    public ResponseEntity<Boolean> memberReg(@RequestBody Map<String, String> data) {
        String id = data.get("id");
        String pwd = data.get("pwd");
        String name = data.get("name");
        String mail = data.get("mail");
        System.out.println("id : " + id + " " + "pwd : " + pwd + " " + "name : " + name + "mail : " + mail);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
