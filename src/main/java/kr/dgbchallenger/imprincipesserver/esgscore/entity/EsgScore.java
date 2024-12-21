package kr.dgbchallenger.imprincipesserver.esgscore.entity;

import jakarta.persistence.*;
import kr.dgbchallenger.imprincipesserver.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EsgScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "e_grade", nullable = false)
    private int eGrade; // 환경 점수

    @Column(name = "s_grade", nullable = false)
    private int sGrade; // 사회 점수

    @Column(name = "g_grade", nullable = false)
    private int gGrade; // 거버넌스 점수

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member; // 멤버와 1:1 관계

    @Builder
    public EsgScore(int eGrade, int sGrade, int gGrade, Member member) {
        this.eGrade = eGrade;
        this.sGrade = sGrade;
        this.gGrade = gGrade;
        this.member = member;
    }
}
