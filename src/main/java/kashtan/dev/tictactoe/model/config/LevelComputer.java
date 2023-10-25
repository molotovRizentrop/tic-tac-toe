package kashtan.dev.tictactoe.model.config;

import kashtan.dev.tictactoe.component.ComputerMoveStrategy;
import kashtan.dev.tictactoe.component.strategy.*;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public enum LevelComputer {

    LEVEL1(new ComputerMoveStrategy[]{
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomMoveComputerStrategy()
    }),

    LEVEL2(new ComputerMoveStrategy[]{
            new WinNowComputerMoveStrategy(),
            new PreventUserWinComputerMoveStrategy(),
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomMoveComputerStrategy()
    }),

    LEVEL3(new ComputerMoveStrategy[]{
            new WinNowComputerMoveStrategy(),
            new PreventUserWinComputerMoveStrategy(),
            new WinOnTheNextStepComputerMoveStrategy(),
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomMoveComputerStrategy()
    });

    private final ComputerMoveStrategy[] strategies;

    LevelComputer(final ComputerMoveStrategy[] strategies) {
        this.strategies = strategies;
    }

    public ComputerMoveStrategy[] getStrategies() {
        return strategies;
    }
}
