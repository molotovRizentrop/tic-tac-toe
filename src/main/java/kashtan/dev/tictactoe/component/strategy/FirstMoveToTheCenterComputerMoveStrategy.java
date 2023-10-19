package kashtan.dev.tictactoe.component.strategy;

import kashtan.dev.tictactoe.component.ComputerMoveStrategy;
import kashtan.dev.tictactoe.model.game.Cell;
import kashtan.dev.tictactoe.model.game.GameTable;
import kashtan.dev.tictactoe.model.game.Sign;

import java.util.Random;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class FirstMoveToTheCenterComputerMoveStrategy implements ComputerMoveStrategy {
    @Override
    public boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        Cell centerCell = new Cell(1, 1);
        if (gameTable.isEmpty(centerCell)) {
            gameTable.setSign(centerCell, sign);
            return true;
        } else {
            return false;
        }
    }
}
