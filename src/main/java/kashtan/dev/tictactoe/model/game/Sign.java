package kashtan.dev.tictactoe.model.game;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public enum Sign {
    X,

    O,

    EMPTY;

    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        } else {
            return name();
        }
    }
}