package kr.dgbchallenger.imprincipesserver.member.entity;

import jakarta.persistence.*;
import kr.dgbchallenger.imprincipesserver.esgscore.entity.EsgScore;
import kr.dgbchallenger.imprincipesserver.apply.entity.MemberLoanProduct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 자동 생성되는 기본 키

    @Column(name = "wallet_address", unique = true, nullable = false)
    private String walletAddress; // 지갑 주소

    @Column(nullable = false)
    private String name; // 이름

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MemberLoanProduct> loanProducts = new HashSet<>(); // 대출상품 다대다 중간 테이블

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private EsgScore esgScore; // ESG 점수

}
