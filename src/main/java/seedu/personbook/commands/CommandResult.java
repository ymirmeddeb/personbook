package seedu.personbook.commands;

import seedu.personbook.data.person.Person;

import java.util.List;


/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    /** The feedback message to be shown to the user. Contains a description of the execution result */
    public final String feedbackToUser;

    /** The list of persons that was produced by the command */
    private final List<Person> relevantPersons;

    public CommandResult(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
        relevantPersons = null;
    }

    public CommandResult(String feedbackToUser, List<Person> relevantPersons) {
        this.feedbackToUser = feedbackToUser;
        this.relevantPersons = relevantPersons;
    }

    /**
     * Returns a list of persons that was produced by the command, if any.
     */
    public List<Person> getRelevantPersons() {
        return relevantPersons;
    }

}
