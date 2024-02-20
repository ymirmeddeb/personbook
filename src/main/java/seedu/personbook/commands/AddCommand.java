package seedu.personbook.commands;

import seedu.personbook.data.exception.IllegalValueException;
import seedu.personbook.data.person.Name;
import seedu.personbook.data.person.Person;
import seedu.personbook.data.person.Phone;
import seedu.personbook.data.person.UniquePersonList;

/**
 * Adds a person to the PersonBook.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the PersonBook. "
            + "Parameters: NAME p/PHONE\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the PersonBook";

    private final Person toAdd;

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public AddCommand(String name,
                      String phone) throws IllegalValueException {

        this.toAdd = new Person(
                new Name(name),
                new Phone(phone)
        );
    }

    public Person getPerson() {
        return toAdd;
    }

    @Override
    public CommandResult execute() {
        try {
            personBook.addPerson(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }
    }

}
