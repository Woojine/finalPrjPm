package com.kh.finalPrjPm.entity;

import com.kh.finalPrjPm.constant.Authority;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter @ToString
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userID;
    private String name;
    private String password; 
    @Column(unique = true)
    private String email;
    @Column(name = "join_time")
    private LocalDateTime joinTime;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String user, String email, String password, String name, Authority auth) {
        this.userID = user;
        this.email = email;
        this.password = password;
        this.name = name;
        this.authority = auth;
    }
}
