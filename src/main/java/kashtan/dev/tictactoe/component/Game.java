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

import kashtan.dev.tictactoe.model.GameTable;
import kashtan.dev.tictactoe.model.Player;

import java.util.Random;

import static kashtan.dev.tictactoe.model.Sign.O;
import static kashtan.dev.tictactoe.model.Sign.X;

/**
 * author:kashtan
 * email:bassanddub.co@gmail.com
 **/
public final class Game {
    private final DataPrinter dataPrinter;
    private final MoveComputer moveComputer;
    private final MoveUser moveUser;
    private final WinnerVerifier winnerVerifier;
    private final CellVerifier cellVerifier;

    public Game(final DataPrinter dataPrinter,
                final MoveComputer moveComputer,
                final MoveUser moveUser,
                final WinnerVerifier winnerVerifier,
                final CellVerifier cellVerifier) {
        this.dataPrinter = dataPrinter;
        this.moveComputer = moveComputer;
        this.moveUser = moveUser;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
    }

    public void play() {

        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMappingTable();
        final GameTable gameTable = new GameTable();

        /*
        if (new Random().nextBoolean()) {
            moveComputer.make(gameTable,players[1].getSign());
            dataPrinter.printGameTable(gameTable);
        }

         */
        
        final Player[] players = {new Player(O, moveUser), new Player(X, moveComputer)};
        while (true) {
            for (final Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);
                if (winnerVerifier.isWinner(gameTable, player)) {
                    System.out.println(player + " WIN!");
                    printGameOver();
                    return;
                }
                if (cellVerifier.allCellsFilled(gameTable)) {
                    System.out.println("Sorry, DRAW!");
                    printGameOver();
                    return;
                }
            }
        }
    }

    private void printGameOver() {
        System.out.println("GAME OVER!");
    }
}