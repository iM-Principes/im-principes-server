package kr.dgbchallenger.imprincipesserver.esgscore.repository;

import kr.dgbchallenger.imprincipesserver.esgscore.entity.EsgScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EsgScoreRepository extends JpaRepository<EsgScore, Long> {
    //Optional<EsgScore> findByMemberId(Long memberId);
}
