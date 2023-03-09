package blackjack.domain.card;

import blackjack.domain.cardPicker.CardPicker;
import blackjack.domain.cardPicker.TestCardPicker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeckTest {
    @Test
    @DisplayName("덱을 생성한다.")
    void constructorDeckTest() {
        List<Card> cards = List.of();
        CardPicker cardPicker = new TestCardPicker();

        Assertions.assertThatNoException().isThrownBy(() -> new Deck(cards, cardPicker));
    }

    @Test
    @DisplayName("카드를 뽑는다")
    void drawCardTest() {
        //given
        List<Card> cards = new ArrayList<>(
                Arrays.asList(
                        new Card(Shape.CLOVER, Letter.ACE),
                        new Card(Shape.DIAMOND, Letter.JACK)));
        CardPicker testCardPicker = new TestCardPicker();
        Deck deck = new Deck(cards, testCardPicker);

        //when
        Card card = deck.drawCard();

        //then
        assertThat(card.getScore()).isEqualTo(Letter.ACE.getValue());
    }

    @Test
    @DisplayName("덱 반환 테스트")
    void getCardsTest() {
        List<Card> cards = new ArrayList<>(
                Arrays.asList(
                        new Card(Shape.CLOVER, Letter.ACE),
                        new Card(Shape.DIAMOND, Letter.JACK)));
        CardPicker testCardPicker = new TestCardPicker();
        Deck deck = new Deck(cards, testCardPicker);

        assertThat(deck.getCards()).isEqualTo(cards);
    }
}
