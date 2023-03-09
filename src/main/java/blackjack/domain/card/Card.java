package blackjack.domain.card;

import java.util.List;

public class Card {
    final private Shape shape;
    final private Letter letter;
    private boolean isOpen;
    public Card(final Shape shape, final Letter letter) {
        this.shape = shape;
        this.letter = letter;
        this.isOpen = true;
    }

    public int getValue() {
        return this.letter.getValue();
    }

    public boolean isAce() {
        return this.letter.isLetterAce();
    }

    public Shape getShape() {
        return shape;
    }

    public Letter getLetter() {
        return letter;
    }
    public boolean isOpen(){return isOpen;}

    public void reverseCard(){this.isOpen = false;}
    public void openCard(){this.isOpen = true;}
}
