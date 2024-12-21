package kr.dgbchallenger.imprincipesserver.infra.dto;

public record IssueSBTRequestDto(
        String walletAddress,
        String contractAddress,
        String name,
        Score score
) {

}
