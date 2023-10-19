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
        Cell winCell;
        for (int column = 0; column < 3; column++) {
            winCell = isWinnerByHorizontalLine(gameTable, sign, column);
            if (winCell != null) {
                if (gameTable.isEmpty(winCell)) {
                    gameTable.setSign(winCell, sign);
                    return true;
                }
            }
        }
        for (int column = 0; column < 3; column++) {
            winCell = isWinnerByVerticalLine(gameTable, sign, column);
            if (winCell != null) {
                if (gameTable.isEmpty(winCell)) {
                    gameTable.setSign(winCell, sign);
                    return true;
                }
            }
        }

        winCell = isWinnerByFirstDiagonalColomn(gameTable, sign);
        if (winCell != null) {
            if (gameTable.isEmpty(winCell)) {
                gameTable.setSign(winCell, sign);
                return true;
            }
        }
        winCell = isWinnerBySecondDiagonalColomn(gameTable, sign);
        if (winCell != null) {
            if (gameTable.isEmpty(winCell)) {
                gameTable.setSign(winCell, sign);
                return true;
            }
        }
        return false;
    }

    private Cell isWinnerByHorizontalLine(final GameTable gameTable, final Sign sign, final int column) {
        if (gameTable.getSign(new Cell(column, 0)) == gameTable.getSign(new Cell(column, 1))
                && gameTable.getSign(new Cell(column, 0)) == sign) {
            return new Cell(column, 2);
        } else if (gameTable.getSign(new Cell(column, 0)) == gameTable.getSign(new Cell(column, 2))
                && gameTable.getSign(new Cell(column, 0)) == sign) {
            return new Cell(column, 1);
        } else if (gameTable.getSign(new Cell(column, 1)) == gameTable.getSign(new Cell(column, 2))
                && gameTable.getSign(new Cell(column, 1)) == sign) {
            return new Cell(column, 0);
        }
        return null;
    }

    private Cell isWinnerByVerticalLine(final GameTable gameTable, final Sign sign, final int column) {
        if (gameTable.getSign(new Cell(0, column)) == gameTable.getSign(new Cell(1, column))
                && gameTable.getSign(new Cell(0, column)) == sign) {
            return new Cell(2, column);
        } else if (gameTable.getSign(new Cell(0, column)) == gameTable.getSign(new Cell(2, column))
                && gameTable.getSign(new Cell(0, column)) == sign) {
            return new Cell(1, column);
        } else if (gameTable.getSign(new Cell(1, column)) == gameTable.getSign(new Cell(2, column))
                && gameTable.getSign(new Cell(1, column)) == sign) {
            return new Cell(0, column);
        }
        return null;
    }

    private Cell isWinnerByFirstDiagonalColomn(final GameTable gameTable, final Sign sign) {
        if (gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1))
                && gameTable.getSign(new Cell(0, 0)) == sign) {
            return new Cell(2, 2);
        } else if (gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(2, 2))
                && gameTable.getSign(new Cell(0, 0)) == sign) {
            return new Cell(1, 1);
        } else if (gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2))
                && gameTable.getSign(new Cell(1, 1)) == sign) {
            return new Cell(0, 0);
        }
        return null;
    }

    private Cell isWinnerBySecondDiagonalColomn(final GameTable gameTable, final Sign sign) {
        if (gameTable.getSign(new Cell(0, 2)) == gameTable.getSign(new Cell(1, 1))
                && gameTable.getSign(new Cell(0, 2)) == sign) {
            return new Cell(2, 0);
        } else if (gameTable.getSign(new Cell(0, 2)) == gameTable.getSign(new Cell(2, 0))
                && gameTable.getSign(new Cell(0, 2)) == sign) {
            return new Cell(1, 1);
        } else if (gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(0, 2))
                && gameTable.getSign(new Cell(1, 1)) == sign) {
            return new Cell(0, 2);
        }
        return null;
    }
}
