package kr.dgbchallenger.imprincipesserver.apply.entity;

import jakarta.persistence.*;
import kr.dgbchallenger.imprincipesserver.loanproduct.entity.LoanProduct;
import kr.dgbchallenger.imprincipesserver.member.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberLoanProduct {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member; // 멤버와 관계

    @ManyToOne
    @JoinColumn(name = "loan_product_id", nullable = false)
    private LoanProduct loanProduct; // 대출 상품과 관계

}
