package kr.dgbchallenger.imprincipesserver.loanproduct.dto;

import kr.dgbchallenger.imprincipesserver.loanproduct.entity.LoanProduct;

import java.util.List;

public record LoanProductResponseDto(
        String productName,
        String loanEligibility,
        Double interestRate,
        String enrollment
) {

}
