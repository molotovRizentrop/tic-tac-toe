package kashtan.dev.tictactoe.component.strategy;

import kashtan.dev.tictactoe.model.game.Sign;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class PreventUserWinComputerMoveStrategy extends AbstractComputerMoveStrategy {
    public PreventUserWinComputerMoveStrategy() {
        super(1);
    }

    @Override
    protected Sign getFindSign(final Sign moveSign) {
        return moveSign.oppositeSign();
    }
}