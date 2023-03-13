package blackjack.view;

import blackjack.dto.CardInfo;
import blackjack.dto.CardsDto;
import blackjack.dto.ParticipantsDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String CHANGE_LINE = "\n";
    private static final String DEALER_ANDE_PLAYER_DELIMITER = "와 ";
    private static final String PLAYERS_DELIMITER = ",";
    private static final String GIVE_TWO_CARD_MASSAGE = "에게 두장을 나누었습니다.";
    private static final String NOTICE_TOTAL_SCORE_UNDER_SIXTEEN = "는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String RESULT_DELIMITER = " - 결과 : ";
    private static final String PLAYER_SCORE_DELIMITER = " : ";
    private static final String PLAYER_DELIMITER = ", ";
    private static final String DEALER_NAME = "딜러";
    private static final String REVENUE_RESULT_MASSAGE = "## 최종 수익";

    public void outputSplitMessage(final List<String> players) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CHANGE_LINE + DEALER_NAME + DEALER_ANDE_PLAYER_DELIMITER);
        stringBuilder.append(String.join(PLAYERS_DELIMITER, players) + GIVE_TWO_CARD_MASSAGE);
        System.out.println(stringBuilder);
        changeLine();
    }


    public void outputParticipantCards(ParticipantsDto participantsDto) {
        System.out.println(playerNameAndCards(DEALER_NAME, participantsDto.getDealerCards()));
        ;
        participantsDto.getParticipantsMap().forEach((name, cards) -> {
            System.out.println(playerNameAndCards(name, cards));
        });
    }

    public void outputPlayerCard(final String name, final CardsDto cards) {
        System.out.println(playerNameAndCards(name, cards));
    }

    private String playerNameAndCards(final String name, final CardsDto cards) {
        return name + PLAYER_SCORE_DELIMITER +
                cards.getCards().stream()
                        .map(this::combineStringWith)
                        .collect(Collectors.joining(PLAYER_DELIMITER));
    }

    private String combineStringWith(CardInfo cardInfo) {
        return cardInfo.getLetter() + cardInfo.getShape();
    }

    public void outputDealerDrawCard() {
        System.out.println(CHANGE_LINE + DEALER_NAME + NOTICE_TOTAL_SCORE_UNDER_SIXTEEN);
        changeLine();
    }

    public void outputCardsAndScore(ParticipantsDto participantsDto) {
        changeLine();
        System.out.print(playerNameAndCards(DEALER_NAME, participantsDto.getDealerCards()));
        outputScore(participantsDto.getDealerCards().getTotalScore());
        changeLine();
        participantsDto.getParticipantsMap().forEach((name, cards) -> {
            System.out.print(playerNameAndCards(name, cards));
            outputScore(cards.getTotalScore());
            changeLine();
        });
        changeLine();
    }

    private void outputScore(final int score) {
        System.out.print(RESULT_DELIMITER + score);
    }

    public void outputRevenue(ParticipantsDto participantsDto) {
        System.out.println(REVENUE_RESULT_MASSAGE);
        outputParticipantRevenue(DEALER_NAME, participantsDto.getDealerRevenue());
        participantsDto.getPlayersRevenue()
                .forEach(this::outputParticipantRevenue);
    }

    private void outputParticipantRevenue(String name, int revenue) {
        System.out.println(name + PLAYER_SCORE_DELIMITER + revenue);
    }

    private void changeLine() {
        System.out.println();
    }
}
