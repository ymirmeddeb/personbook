package seedu.personbook;

import seedu.personbook.commands.Command;
import seedu.personbook.commands.CommandResult;
import seedu.personbook.commands.ExitCommand;
import seedu.personbook.data.PersonBook;
import seedu.personbook.parser.Parser;
import seedu.personbook.ui.TextUi;


/**
 * Entry point of the PersonBook application.
 * Initializes the application and starts the interaction with the user.
 */
public class Main {

    /** Version info of the program. */
    public static final String VERSION = "PersonBook - Version 1.0";

    private TextUi ui;
    private PersonBook personBook = new PersonBook();


    public static void main(String[] args) {
        new Main().run();
    }

    /** Runs the program until termination.  */
    public void run() {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    /**
     * Sets up the required objects, and prints the welcome message.
     *
     */
    private void start() {
        this.ui = new TextUi();
        ui.showWelcomeMessage(VERSION);
    }

    /** Prints the Goodbye message and exits. */
    private void exit() {
        ui.showGoodbyeMessage();
        System.exit(0);
    }

    /** Reads the user command and executes it, until the user issues the exit command.  */
    private void runCommandLoopUntilExitCommand() {
        Command command;
        do {
            String userCommandText = ui.getUserCommand();
            command = new Parser().parseCommand(userCommandText);
            CommandResult result = executeCommand(command);
            personBook.setLastShownList(result.getRelevantPersons());
            ui.showResultToUser(result);

        } while (!ExitCommand.isExit(command));
    }


    /**
     * Executes the command and returns the result.
     *
     * @param command user command
     * @return result of the command
     */
    private CommandResult executeCommand(Command command) {
        try {
            command.setData(personBook);
            CommandResult result = command.execute();
            return result;
        } catch (Exception e) {
            ui.showToUser(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
