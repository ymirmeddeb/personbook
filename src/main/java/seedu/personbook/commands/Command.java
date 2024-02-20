package seedu.personbook.commands;

import seedu.personbook.common.Messages;
import seedu.personbook.data.PersonBook;
import seedu.personbook.data.person.Person;

import java.util.List;

import static seedu.personbook.ui.TextUi.DISPLAYED_INDEX_OFFSET;

/**
 * Represents an executable command.
 */
public class Command {
    protected PersonBook personBook;
    private int targetIndex = -1;

    /**
     * @param targetIndex last visible listing index of the target person
     */
    public Command(int targetIndex) {
        this.setTargetIndex(targetIndex);
    }

    protected Command() {
    }

    /**
     * Constructs a feedback message to summarise an operation that displayed a listing of persons.
     *
     * @param personsDisplayed used to generate summary
     * @return summary message for persons displayed
     */
    public static String getMessageForPersonListShownSummary(List<Person> personsDisplayed) {
        return String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, personsDisplayed.size());
    }

    /**
     * Executes the command and returns the result.
     */
    public CommandResult execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    };

    /**
     * Supplies the data the command will operate on.
     */
    public void setData(PersonBook personBook) {
        this.personBook = personBook;
    }

    /**
     * Extracts the the target person in the last shown list from the given arguments.
     *
     * @throws IndexOutOfBoundsException if the target index is out of bounds of the last viewed listing
     */
    protected Person getTargetPerson() throws IndexOutOfBoundsException {
        return personBook.getLastShownList().get(getTargetIndex() - DISPLAYED_INDEX_OFFSET);
    }

    public int getTargetIndex() {
        return targetIndex;
    }

    public void setTargetIndex(int targetIndex) {
        this.targetIndex = targetIndex;
    }
}
