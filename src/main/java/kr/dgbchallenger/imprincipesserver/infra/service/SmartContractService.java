package kr.dgbchallenger.imprincipesserver.infra.service;

import kr.dgbchallenger.imprincipesserver.esgscore.entity.EsgScore;
import kr.dgbchallenger.imprincipesserver.esgscore.repository.EsgScoreRepository;
import kr.dgbchallenger.imprincipesserver.infra.dto.IssueSBTRequestDto;
import kr.dgbchallenger.imprincipesserver.infra.dto.Score;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class SmartContractService {

    private final ContractSender contractSender;
    private final EsgScoreRepository esgScoreRepository;

    public EsgScore issue(IssueSBTRequestDto requestDto) throws Exception {

        EsgScore esgScore = contractSender.send(requestDto);
        return esgScoreRepository.save(esgScore);
    }

    private void validateScores(Score score) {
        if (score.r() < 0 || score.r() > 100 ||
                score.e() < 0 || score.e() > 100 ||
                score.s() < 0 || score.s() > 100 ||
                score.g() < 0 || score.g() > 100) {
            throw new IllegalArgumentException("Scores must be between 0 and 100");
        }
    }
}
