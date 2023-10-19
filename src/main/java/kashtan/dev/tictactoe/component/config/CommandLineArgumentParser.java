package kashtan.dev.tictactoe.component.config;

import kashtan.dev.tictactoe.model.config.PlayerType;
import kashtan.dev.tictactoe.model.config.UserInterface;

import static kashtan.dev.tictactoe.model.config.PlayerType.COMPUTER;
import static kashtan.dev.tictactoe.model.config.PlayerType.USER;
import static kashtan.dev.tictactoe.model.config.UserInterface.CONSOLE;
import static kashtan.dev.tictactoe.model.config.UserInterface.GUI;

/**
 * @author:kashtan
 * @email:bassanddub.co@gmail.com
 **/
public class CommandLineArgumentParser {
    private final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public CommandLineArguments parse() {
        PlayerType playerType1 = null;
        PlayerType playerType2 = null;
        UserInterface userInterface = null;

        for (final String arg : args) {
            if (USER.name().equals(arg.toUpperCase()) || COMPUTER.name().equals(arg.toUpperCase())) {
                if (playerType1 == null) {
                    playerType1 = PlayerType.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = PlayerType.valueOf(arg.toUpperCase());
                }  else {
                    System.err.printf(
                            "Invalid command line argument: '%s', because player types already set: %n" +
                                    "player1Type='%s'%nplayer2Type='%s'%n", arg, playerType1, playerType2
                    );
                }
            } else if (GUI.name().equals(arg.toUpperCase()) || CONSOLE.name().equals(arg.toUpperCase())) {
                if (userInterface == null) {
                    userInterface = UserInterface.valueOf(arg.toUpperCase());
                } else {
                    System.err.printf(
                            "Invalid command line argument: '%s', because user interface already set: '%s'!%n",
                            arg, userInterface
                    );
                }
            } else {
                System.err.printf("Unsupported command line argument: '%s'%n", arg);
            }
        }

        if (userInterface == null) {
            userInterface = CONSOLE;
        }

        return new CommandLineArguments(playerType1, playerType2, userInterface);
    }

    public static class CommandLineArguments {
        private final PlayerType playerType1;
        private final PlayerType playerType2;
        private final UserInterface userInterface;

        public CommandLineArguments(final PlayerType playerType1,
                                    final PlayerType playerType2,
                                    final UserInterface userInterface) {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
            this.userInterface = userInterface;
        }

        public PlayerType getPlayerType1() {
            return playerType1;
        }

        public PlayerType getPlayerType2() {
            return playerType2;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }
    }
}
