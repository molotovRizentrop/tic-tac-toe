package kashtan.dev.tictactoe.component;

import kashtan.dev.tictactoe.model.GameTable;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public interface DataPrinter {

    void printInstruction();

    void printInfoMessage(String text);

    void printErrorMessage(String text);

    void printGameTable(GameTable gameTable);
}
