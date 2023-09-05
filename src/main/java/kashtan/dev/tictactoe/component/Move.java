package kashtan.dev.tictactoe.component;

import kashtan.dev.tictactoe.model.game.GameTable;
import kashtan.dev.tictactoe.model.game.Sign;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public interface Move {
    void make(final GameTable gameTable, Sign sign);
}
