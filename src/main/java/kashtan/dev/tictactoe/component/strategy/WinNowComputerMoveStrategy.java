package kashtan.dev.tictactoe.component.strategy;

import kashtan.dev.tictactoe.component.ComputerMoveStrategy;
import kashtan.dev.tictactoe.model.game.Cell;
import kashtan.dev.tictactoe.model.game.GameTable;
import kashtan.dev.tictactoe.model.game.Sign;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class WinNowComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveByRows(gameTable, sign) ||
                tryToMakeMoveByCols(gameTable, sign) ||
                tryToMakeMoveByMainDiagonal(gameTable, sign) ||
                tryToMakeMoveBySecondaryDiagonal(gameTable, sign);
    }

    @SuppressWarnings("Convert2MethodRef")
    private boolean tryToMakeMoveByRows(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMakeMoveUseLambda(gameTable, sign, i, ((k, j) -> new Cell(k, j)))) {
                return true;
            }
        }
        return false;
    }

    private boolean tryToMakeMoveByCols(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 3; i++) {
            if (tryToMakeMoveUseLambda(gameTable, sign, i, ((k, j) -> new Cell(j, k)))) {
                return true;
            }
        }
        return false;
    }

    private boolean tryToMakeMoveByMainDiagonal(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveUseLambda(gameTable, sign, -1, ((k, j) -> new Cell(j, j)));
    }

    private boolean tryToMakeMoveBySecondaryDiagonal(final GameTable gameTable, final Sign sign) {
        return tryToMakeMoveUseLambda(gameTable, sign, -1, ((k, j) -> new Cell(j, 2 - j)));
    }

    private boolean tryToMakeMoveUseLambda(final GameTable gameTable,
                                           final Sign sign,
                                           final int i,
                                           final Lambda lambda) {
        int countEmptyCells = 0;
        int countSignCells = 0;
        Cell lastEmptyCell = null;
        for (int j = 0; j < 3; j++) {
            final Cell cell = lambda.getCell(i, j);
            if (gameTable.isEmpty(cell)) {
                lastEmptyCell = cell;
                countEmptyCells++;
            } else if (gameTable.getSign(cell) == sign) {
                countSignCells++;
            } else {
                break;
            }
        }
        if (countEmptyCells == 1 && countSignCells == 2) {
            gameTable.setSign(lastEmptyCell, sign);
            return true;
        }
        return false;
    }

    /**
     * @author:kashtan
     * @email:bassanddub.co@gmail.com
     **/
    @FunctionalInterface
    private interface Lambda {
        Cell getCell(int k, int j);
    }
}
