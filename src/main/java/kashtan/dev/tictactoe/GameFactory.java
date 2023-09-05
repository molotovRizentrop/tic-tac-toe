package kashtan.dev.tictactoe;

import kashtan.dev.tictactoe.component.*;
import kashtan.dev.tictactoe.component.config.CommandLineArgumentParser;
import kashtan.dev.tictactoe.component.console.CellNumberConverter;
import kashtan.dev.tictactoe.component.console.ConsoleDataPrinter;
import kashtan.dev.tictactoe.component.console.ConsoleGameOverHandler;
import kashtan.dev.tictactoe.component.console.ConsoleUserInputReader;
import kashtan.dev.tictactoe.component.swing.GameWindow;
import kashtan.dev.tictactoe.component.console.keypad.DesktopNumericKeypadCellNumberConverter;
import kashtan.dev.tictactoe.model.game.Player;
import kashtan.dev.tictactoe.model.config.PlayerType;
import kashtan.dev.tictactoe.model.config.UserInterface;

import static kashtan.dev.tictactoe.model.config.PlayerType.COMPUTER;
import static kashtan.dev.tictactoe.model.config.PlayerType.USER;
import static kashtan.dev.tictactoe.model.game.Sign.O;
import static kashtan.dev.tictactoe.model.game.Sign.X;
import static kashtan.dev.tictactoe.model.config.UserInterface.GUI;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class GameFactory {
    private final PlayerType playerType1;
    private final PlayerType playerType2;
    private final UserInterface userInterface;

    public GameFactory(final String[] args) {
        CommandLineArgumentParser.CommandLineArguments commandLineArguments =
                new CommandLineArgumentParser(args).parse();
        playerType1 = commandLineArguments.getPlayerType1();
        playerType2 = commandLineArguments.getPlayerType2();
        userInterface = commandLineArguments.getUserInterface();
    }

    public Game create() {
        final DataPrinter dataPrinter;
        final UserInputReader userInputReader;
        final GameOverHandler gameOverHandler;
        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInputReader = gameWindow;
            gameOverHandler = gameWindow;
        } else {
            final CellNumberConverter cellNumberConverter = new DesktopNumericKeypadCellNumberConverter();
            dataPrinter = new ConsoleDataPrinter(cellNumberConverter);
            userInputReader = new ConsoleUserInputReader(cellNumberConverter, dataPrinter);
            gameOverHandler = new ConsoleGameOverHandler(dataPrinter);
        }

        boolean canSecondPlayerMakeMove = (playerType1 != playerType2);

        Player player1 = new Player(X, new MoveUser(userInputReader, dataPrinter));
        Player player2 = new Player(O, new MoveComputer());

        if (playerType1 == COMPUTER && playerType2 == COMPUTER) {
            player1 = new Player(X, new MoveComputer());
        } else if (playerType1 == USER && playerType2 == USER) {
            player2 = new Player(O, new MoveUser(userInputReader, dataPrinter));
        }

        return new Game(
                dataPrinter,
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                gameOverHandler,
                canSecondPlayerMakeMove);
    }
}
