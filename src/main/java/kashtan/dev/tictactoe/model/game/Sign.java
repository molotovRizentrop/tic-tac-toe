package kashtan.dev.tictactoe.model.game;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public enum Sign {
    X,

    O,

    EMPTY;

    public Sign oppositeSign(){
        if (this == X){
            return O;
        }else if (this == O){
            return X;
        }else {
            throw new IllegalStateException("Empty values does not have an oppositive one!");
        }
    }

    @Override
    public String toString() {
        if (this == EMPTY) {
            return " ";
        } else {
            return name();
        }
    }
}
