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

import java.util.Random;

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
        Move[] moves = new Move[]{moveUser, moveComputer};
        System.out.println("choose the position");
        dataPrinter.printMappingTable();
        GameTable gameTable = new GameTable();
        if (new Random().nextBoolean()) {
            moveComputer.make(gameTable);
            dataPrinter.printGameTable(gameTable);
        }

        boolean gameOver = true;
        while (gameOver) {
            for (Move move : moves) {
                move.make(gameTable);
                dataPrinter.printGameTable(gameTable);
                if (move.getClass() == moveUser.getClass()) {
                    if (winnerVerifier.isUserWin(gameTable)) {
                        System.out.println("cong User");
                        gameOver = false;
                    }
                } else {
                    if (winnerVerifier.isComputerWin(gameTable)) {
                        System.out.println("cong Comp");
                        gameOver = false;
                    }
                }
                if (cellVerifier.allCellsFilled(gameTable)) {
                    System.out.println("draw");
                    gameOver = false;
                }
            }
        }
        System.out.println("game over");
    }
}
