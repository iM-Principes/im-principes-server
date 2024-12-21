package kr.dgbchallenger.imprincipesserver.infra.service;

import kr.dgbchallenger.imprincipesserver.esgscore.entity.EsgScore;
import kr.dgbchallenger.imprincipesserver.infra.dto.IssueSBTRequestDto;

public interface ContractSender {
    EsgScore send(IssueSBTRequestDto issueSBTRequestDto);
}
