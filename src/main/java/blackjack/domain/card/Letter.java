package blackjack.domain.card;

public enum Letter {
    ACE(11),
    TWO(2),
    THREE( 3),
    FOUR( 4),
    FIVE( 5),
    SIX( 6),
    SEVEN( 7),
    EIGHT( 8),
    NINE(9),
    TEN( 10),
    JACK(10),
    QUEEN( 10),
    KING( 10);


    private final int value;

    Letter( final int value) {

        this.value = value;
    }

    public boolean isLetterAce() {
        return this.equals(ACE);
    }

    public int getValue() {
        return this.value;
    }
}
