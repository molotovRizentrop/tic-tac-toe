package kashtan.dev.tictactoe.component;

import kashtan.dev.tictactoe.model.PlayerType;

import static kashtan.dev.tictactoe.model.PlayerType.COMPUTER;
import static kashtan.dev.tictactoe.model.PlayerType.USER;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class CommandLineArgumentParser {
    private final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public PlayerTypes parse() {
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;

        for (final String arg : args) {
            if (USER.name().equals(arg.toUpperCase()) ||
                    COMPUTER.name().equals(arg.toUpperCase())) {
                if (playerType1 == null) {
                    playerType1 = PlayerType.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command line argument: '" + arg + "'");
                }
            } else {
                System.err.println("Unsupported command line argument: '" + arg + "'");
            }
        }
        return new PlayerTypes(playerType1, playerType2);
    }

    public static class PlayerTypes {
        private final PlayerType playerType1;
        private final PlayerType playerType2;

        public PlayerTypes(final PlayerType playerType1, final PlayerType playerType2) {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
        }

        public PlayerType getPlayerType1() {
            return playerType1;
        }

        public PlayerType getPlayerType2() {
            return playerType2;
        }
    }
}
