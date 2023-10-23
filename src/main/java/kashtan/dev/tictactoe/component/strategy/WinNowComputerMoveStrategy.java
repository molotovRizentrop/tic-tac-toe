package kashtan.dev.tictactoe.component.strategy;

import kashtan.dev.tictactoe.component.ComputerMoveStrategy;
import kashtan.dev.tictactoe.model.game.Cell;
import kashtan.dev.tictactoe.model.game.GameTable;
import kashtan.dev.tictactoe.model.game.Sign;

import javax.sound.sampled.Line;

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

    private boolean tryToMakeMoveByRows(final GameTable gameTable, final Sign sign) {
        return LineLambdaTryToMakeMove((i, j) -> new Cell(i, j), gameTable, sign);
    }

    private boolean tryToMakeMoveByCols(final GameTable gameTable, final Sign sign) {
        return LineLambdaTryToMakeMove((i, j) -> new Cell(j, i), gameTable, sign);
    }

    private boolean tryToMakeMoveByMainDiagonal(final GameTable gameTable, final Sign sign) {
        return DiagonalLambdaTryToMakeMove((i, j) -> new Cell(j, j), gameTable, sign);
    }

    private boolean tryToMakeMoveBySecondaryDiagonal(final GameTable gameTable, final Sign sign) {
        return DiagonalLambdaTryToMakeMove((i, j) -> new Cell(j, 2 - j), gameTable, sign);
    }


    private boolean DiagonalLambdaTryToMakeMove(Lambda lambda, GameTable gameTable, Sign sign) {
        int countEmptyCells = 0;
        int countSignCells = 0;
        Cell lastEmptyCell = null;
        for (int j = 0; j < 3; j++) {
            final Cell cell = lambda.getCell(j, j);
            //final Cell cell = new Cell(j, 2 - j);
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

    private boolean LineLambdaTryToMakeMove(Lambda lambda, GameTable gameTable, Sign sign) {
        for (int i = 0; i < 3; i++) {
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
        }
        return false;
    }

    @FunctionalInterface
    private interface LambdaLine {
        Cell getCell(int i, int j);
    }

    @FunctionalInterface
    private interface Lambda {
        Cell getCell(int i, int j);
    }
}
