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
public class RandomMoveComputerStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        final Cell[] emptyCells = new Cell[9];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final Cell cell = new Cell(i, j);
                if (gameTable.isEmpty(cell)) {
                    emptyCells[count++] = cell;
                }
            }
        }
        if (count > 0) {
            final Cell randomCell = emptyCells[new Random().nextInt(count)];
            gameTable.setSign(randomCell, sign);
            return true;
        } else {
            return false;
        }
    }
}
