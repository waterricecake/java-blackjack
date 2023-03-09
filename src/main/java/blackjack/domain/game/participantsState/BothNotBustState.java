package blackjack.domain.game.participantsState;

import blackjack.domain.game.WinTieLose;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;

import java.util.HashMap;

public class BothNotBustState implements StateExecutor {
    @Override
    public void calculateResult(HashMap<Player, WinTieLose> playersResult, Player player, Dealer dealer) {
        if (player.isScoreSameWith(dealer)) {
            playersResult.put(player, WinTieLose.TIE);
        }
        if (player.isScoreBiggerThan(dealer)) {
            playersResult.put(player, WinTieLose.WIN);
        }
        if (player.isScoreSmallerThan(dealer)) {
            playersResult.put(player, WinTieLose.LOSE);
        }
    }
}
