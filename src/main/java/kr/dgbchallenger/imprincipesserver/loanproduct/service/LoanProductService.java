package kr.dgbchallenger.imprincipesserver.loanproduct.service;

import kr.dgbchallenger.imprincipesserver.loanproduct.dto.LoanProductResponseDto;
import kr.dgbchallenger.imprincipesserver.loanproduct.entity.LoanProduct;
import kr.dgbchallenger.imprincipesserver.loanproduct.repository.LoanProductRepository;
import kr.dgbchallenger.imprincipesserver.member.entity.Member;
import kr.dgbchallenger.imprincipesserver.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoanProductService {
    private final LoanProductRepository loanProductRepository;
    private final MemberRepository memberRepository;

    public List<LoanProductResponseDto> getAllLoanProducts(String walletAddress) {
        // Member 정보 가져오기
        Member member = memberRepository.findByWalletAddress(walletAddress);
        if (member == null || member.getEsgScore() == null) {
            throw new IllegalArgumentException("Member or ESG score not found");
        }

        // Member ESG 점수 가져오기
        int eGrade = member.getEsgScore().getEGrade();
        int sGrade = member.getEsgScore().getSGrade();
        int gGrade = member.getEsgScore().getGGrade();

        // 대출상품 목록 가져오기
        List<LoanProduct> loanProducts = loanProductRepository.findAll();

        // ESG 등급에 따른 이자율 조정
        return loanProducts.stream()
                .map(product -> new LoanProductResponseDto(
                        product.getProductName(),
                        product.getLoanEligibility(),
                        adjustInterestRate(product.getInterestRate(), eGrade, sGrade, gGrade),
                        product.getEnrollment()
                ))
                .toList();
    }

    // 이자율 조정 로직
    private double adjustInterestRate(double baseInterestRate, int eGrade, int sGrade, int gGrade) {
        if (eGrade <= 3 && sGrade <= 3 && gGrade <= 3) {
            return baseInterestRate - 0.5; // 기준 금리에서 0.5% 인하
        }
        return baseInterestRate;
    }
}
