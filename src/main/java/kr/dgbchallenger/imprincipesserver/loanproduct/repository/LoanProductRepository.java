package kr.dgbchallenger.imprincipesserver.loanproduct.repository;

import kr.dgbchallenger.imprincipesserver.loanproduct.entity.LoanProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanProductRepository extends JpaRepository<LoanProduct, Long> {
}
