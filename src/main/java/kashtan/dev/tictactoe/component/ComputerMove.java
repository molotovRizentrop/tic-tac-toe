/*
 * Copyright (c) 2022. http://dev.kashtan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kashtan.dev.tictactoe.component;

import kashtan.dev.tictactoe.model.game.GameTable;
import kashtan.dev.tictactoe.model.game.Sign;

import static java.lang.String.format;

/**
 * author:kashtan
 * email:bassanddub.co@gmail.com
 **/
public class ComputerMove implements Move {

    private final ComputerMoveStrategy[] strategies;

    public ComputerMove(final ComputerMoveStrategy[] strategies) {
        this.strategies = strategies;
    }

    @Override
    public void make(final GameTable gameTable, final Sign sign) {
        for (final ComputerMoveStrategy strategy : strategies) {
            if (strategy.tryToMakeMove(gameTable, sign)) {
                return;
            }
        }
        throw new IllegalArgumentException(
                "Game table does not contain empty cells or invalid configuration for the computer move strategies!"
        );
    }
}
