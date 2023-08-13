package kashtan.dev.tictactoe.component;

import kashtan.dev.tictactoe.keypad.TerminalNumericKeypadCellNumberConverter;
import kashtan.dev.tictactoe.model.Player;
import kashtan.dev.tictactoe.model.PlayerType;

import static kashtan.dev.tictactoe.model.PlayerType.COMPUTER;
import static kashtan.dev.tictactoe.model.PlayerType.USER;
import static kashtan.dev.tictactoe.model.Sign.O;
import static kashtan.dev.tictactoe.model.Sign.X;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class GameFactory {
    private PlayerType playerType1 = null;
    private PlayerType playerType2 = null;

    public GameFactory(final String[] args) {
        for (final String arg : args) {
            if (USER.name().equals(arg.toUpperCase()) ||
                    COMPUTER.name().equals(arg.toUpperCase())) {
                if (playerType1 == null) {
                    playerType1 = PlayerType.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command line argument: '" + arg + "'");
                }
            } else {
                System.err.println("Unsupported command line argument: '" + arg + "'");
            }
        }
    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        boolean canSecondPlayerMakeMove = (playerType1 != playerType2);

        Player player1 = new Player(X, new MoveUser(cellNumberConverter));
        Player player2 = new Player(O, new MoveComputer());

        if (playerType1 == COMPUTER && playerType2 == COMPUTER) {
            player1 = player2;
        } else if (playerType1 == USER && playerType2 == USER) {
            player2 = player1;
        }

        return new Game(
                new DataPrinter(cellNumberConverter),
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                canSecondPlayerMakeMove);
    }
}
