package kr.dgbchallenger.imprincipesserver.loanproduct.api;

import kr.dgbchallenger.imprincipesserver.loanproduct.dto.LoanProductResponseDto;
import kr.dgbchallenger.imprincipesserver.loanproduct.entity.LoanProduct;
import kr.dgbchallenger.imprincipesserver.loanproduct.service.LoanProductService;
import kr.dgbchallenger.imprincipesserver.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanProductController {
    private final LoanProductService loanProductService;

    @GetMapping
    public ResponseEntity<List<LoanProductResponseDto>> getLoanProducts(
            @RequestBody String walletAddress
    ) {
        List<LoanProductResponseDto> loanProducts = loanProductService.getAllLoanProducts(walletAddress);
        return ResponseEntity.ok(loanProducts);
    }

}
