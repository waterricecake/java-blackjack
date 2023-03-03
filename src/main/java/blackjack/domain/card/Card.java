package blackjack.domain.card;

import blackjack.domain.card.Letter;
import blackjack.domain.card.Shape;

public class Card {
    final private Shape shape;
    final private Letter letter;

    public Card(final Shape shape, final Letter letter) {
        this.shape = shape;
        this.letter = letter;
    }

    public String getCardName() {
        return letter.name() + shape.name();
    }

    public int getValue() {
        return this.letter.getValue();
    }
}