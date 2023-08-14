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
    private final PlayerType playerType1;
    private final PlayerType playerType2;

    public GameFactory(final String[] args) {
        CommandLineArgumentParser.PlayerTypes playerTypes =
                new CommandLineArgumentParser(args).parse();
        playerType1 = playerTypes.getPlayerType1();
        playerType2 = playerTypes.getPlayerType2();
    }

    public Game create() {
        final CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        boolean canSecondPlayerMakeMove = (playerType1 != playerType2);

        Player player1 = new Player(X, new MoveUser(cellNumberConverter));
        Player player2 = new Player(O, new MoveComputer());

        if (playerType1 == COMPUTER && playerType2 == COMPUTER) {
            player1 = new Player(X, new MoveComputer());
        } else if (playerType1 == USER && playerType2 == USER) {
            player2 = new Player(O, new MoveUser(cellNumberConverter));
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
