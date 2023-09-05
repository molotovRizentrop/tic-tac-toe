package kashtan.dev.tictactoe.component.console;

import kashtan.dev.tictactoe.component.DataPrinter;
import kashtan.dev.tictactoe.component.GameOverHandler;

import java.util.Scanner;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class ConsoleGameOverHandler implements GameOverHandler {
    private final DataPrinter dataPrinter;

    public ConsoleGameOverHandler(final DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void gameOver() {
    dataPrinter.printInfoMessage("GAME OVER!");
    new Scanner(System.in).nextLine();
    }
}
