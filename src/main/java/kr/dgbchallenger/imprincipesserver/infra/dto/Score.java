package kr.dgbchallenger.imprincipesserver.infra.dto;

public record Score(
        int r,
        int e,
        int s,
        int g
) {
    public static Score of(int r, int e, int s, int g) {
        validateScores(r, e, s, g);
        return new Score(r, e, s, g);
    }

    private static void validateScores(int r, int e, int s, int g) {
        if (r < 0 || r > 100 ||
                e < 0 || e > 100 ||
                s < 0 || s > 100 ||
                g < 0 || g > 100) {
            throw new IllegalArgumentException("Scores must be between 0 and 100");
        }
    }
}
