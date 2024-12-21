package kr.dgbchallenger.imprincipesserver.loanproduct.entity;

import jakarta.persistence.*;
import kr.dgbchallenger.imprincipesserver.apply.entity.MemberLoanProduct;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoanProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName; // 상품명

    @Column(name = "loan_eligibility", nullable = false)
    private String loanEligibility; // 대출 대상

    @Column(name = "interest_rate", nullable = false)
    private Double interestRate; // 이자율

    @Column(nullable = false)
    private String enrollment; // 가입 정보

    @OneToMany(mappedBy = "loanProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MemberLoanProduct> members = new HashSet<>(); // 멤버 다대다 중간 테이블


}
