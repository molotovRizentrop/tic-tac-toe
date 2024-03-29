package kashtan.dev.tictactoe.component.strategy;
import kashtan.dev.tictactoe.model.game.Sign;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class WinNowComputerMoveStrategy extends AbstractComputerMoveStrategy{
    public WinNowComputerMoveStrategy() {
        super(1);
    }

    @Override
    protected Sign getFindSign(final Sign moveSign) {
        return moveSign;
    }
}