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

import kashtan.dev.tictactoe.model.game.Cell;
import kashtan.dev.tictactoe.model.game.GameTable;
import kashtan.dev.tictactoe.model.game.Sign;

import java.util.Random;

import static java.lang.String.format;

/**
 * author:kashtan
 * email:bassanddub.co@gmail.com
 **/
public class MoveComputer implements Move {
    private boolean AllCellsIsFilled(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (gameTable.isEmpty(new Cell(i, j))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void make(final GameTable gameTable, final Sign sign) {
        if (AllCellsIsFilled(gameTable, sign)) {
            throw new IllegalArgumentException(
                    format("Game table does not contain any empty cell!")
            );
        }

        final Random random = new Random();
        while (true) {
            final int row = random.nextInt(3);
            final int col = random.nextInt(3);
            final Cell randomCell = new Cell(row, col);
            if (gameTable.isEmpty(randomCell)) {
                gameTable.setSign(randomCell, sign);
                return;
            }
        }
    }
}
