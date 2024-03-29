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

package kashtan.dev.tictactoe.component.console;

import kashtan.dev.tictactoe.model.game.Cell;

/**
 * author:kashtan
 * email:bassanddub.co@gmail.com
 **/
public interface CellNumberConverter {
    Cell toCell(char number);

    char toNumber(final Cell cell);
}
