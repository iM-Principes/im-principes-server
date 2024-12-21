package kr.dgbchallenger.imprincipesserver.member.repository;

import kr.dgbchallenger.imprincipesserver.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByWalletAddress(String walletAddress);
}
