package kashtan.dev.tictactoe.component;

import kashtan.dev.tictactoe.keypad.TerminalNumericKeypadCellNumberConverter;
import kashtan.dev.tictactoe.model.Player;
import kashtan.dev.tictactoe.model.PlayerType;

import static kashtan.dev.tictactoe.model.Sign.O;
import static kashtan.dev.tictactoe.model.Sign.X;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class GameFactory {
    private final PlayerType playerType1 = PlayerType.USER;
    private final PlayerType playerType2 = PlayerType.COMPUTER;

    public GameFactory(final String[] args){
        // TODO
    }

    public Game create() {
        CellNumberConverter cellNumberConverter = new TerminalNumericKeypadCellNumberConverter();
        return new Game(
                new DataPrinter(cellNumberConverter),
                //  FIXME
                new Player(X, new MoveUser(cellNumberConverter)),
                new Player(O, new MoveComputer()),
                new WinnerVerifier(),
                new CellVerifier(),
                false);
    }
}
