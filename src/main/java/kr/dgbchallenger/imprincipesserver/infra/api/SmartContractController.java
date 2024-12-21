package kr.dgbchallenger.imprincipesserver.infra.api;

import kr.dgbchallenger.imprincipesserver.esgscore.entity.EsgScore;
import kr.dgbchallenger.imprincipesserver.infra.dto.IssueSBTRequestDto;
import kr.dgbchallenger.imprincipesserver.infra.service.SmartContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class SmartContractController {
    private final SmartContractService smartContractService;

    @PostMapping("/issue")
    public ResponseEntity<?> issueSBT(@RequestBody IssueSBTRequestDto requestDto) {
        try {
            // 서비스 호출
            EsgScore response = smartContractService.issue(requestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
