package kr.dgbchallenger.imprincipesserver.infra.service;

import kr.dgbchallenger.imprincipesserver.esgscore.entity.EsgScore;
import kr.dgbchallenger.imprincipesserver.infra.dto.IssueSBTRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

@Service
@RequiredArgsConstructor
public class Web3jSender implements ContractSender{

    private final Web3j web3j;
//    private final Credentials credentials;
//    private final ContractGasProvider contractGasProvider;


    @Override
    public EsgScore send(IssueSBTRequestDto issueSBTRequestDto) {
        return null;
    }
}

