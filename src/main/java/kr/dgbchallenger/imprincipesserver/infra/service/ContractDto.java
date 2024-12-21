package kr.dgbchallenger.imprincipesserver.infra.service;

import kr.dgbchallenger.imprincipesserver.infra.dto.Score;

public record ContractDto (
        String walletAddress,
        String contractAddress,
        String name,
        Score score
) {

}
