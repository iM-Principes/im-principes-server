package kr.dgbchallenger.imprincipesserver.apply.repository;

import kr.dgbchallenger.imprincipesserver.apply.entity.MemberLoanProduct;
import kr.dgbchallenger.imprincipesserver.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberLoanProductRepository extends JpaRepository<MemberLoanProduct, Long> {
    List<MemberLoanProduct> findByMember(Member member);

}
