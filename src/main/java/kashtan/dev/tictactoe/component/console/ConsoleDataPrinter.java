package kashtan.dev.tictactoe.component.console;

import kashtan.dev.tictactoe.component.CellNumberConverter;
import kashtan.dev.tictactoe.component.DataPrinter;
import kashtan.dev.tictactoe.model.Cell;
import kashtan.dev.tictactoe.model.GameTable;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class ConsoleDataPrinter implements DataPrinter {
    private final CellNumberConverter cellNumberConverter;

    public ConsoleDataPrinter(final CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    @Override
    public void printInstruction() {
        printInfoMessage("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        print((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j))));
    }

    @Override
    public void printInfoMessage(final String text) {
        System.out.println(text);
    }

    @Override
    public void printErrorMessage(final String text) {
        System.err.println(text);
    }

    @Override
    public void printGameTable(final GameTable gameTable) {
        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));
    }

    public void print(final Lambda lambda) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i, j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    @FunctionalInterface
    private interface Lambda {
        String getValue(int i, int j);
    }
}
