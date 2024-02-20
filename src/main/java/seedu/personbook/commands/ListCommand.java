package seedu.personbook.commands;

import seedu.personbook.data.person.Person;

import java.util.List;


/**
 * Lists all persons in the PersonBook to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the PersonBook as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<Person> allPersons = personBook.getAllPersons();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
