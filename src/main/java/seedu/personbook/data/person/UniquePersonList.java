package seedu.personbook.data.person;

import seedu.personbook.data.exception.DuplicateDataException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A list of persons. Does not allow null elements or duplicates.
 *
 * @see Person#equals(Object)
 */
public class UniquePersonList {


    private final List<Person> internalList = new ArrayList<>();

    /**
     * Constructs empty person list.
     */
    public UniquePersonList() {}


    /**
     * Returns an unmodifiable java List view with elements cast as immutable {@link Person}s.
     * For use with other methods/libraries.
     * Any changes to the internal list/elements are immediately visible in the returned list.
     */
    public List<Person> immutableListView() {
        return Collections.unmodifiableList(internalList);
    }


    /**
     * Checks if the list contains an equivalent person as the given argument.
     * The {@link Person#isSamePerson} method is used for this comparison, which
     * defines a weaker notion of equality.
     */
    public boolean contains(Person toCheck) {
        for (Person p : internalList) {
            if (p.isSamePerson(toCheck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a person to the list.
     *
     * @throws DuplicatePersonException if the person to add is a duplicate of an existing person in the list.
     *    The @link{Person#isSamePerson} method is used for this comparison,
     *    which defines a weaker notion of equality.
     */
    public void add(Person toAdd) throws DuplicatePersonException {
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        internalList.add(toAdd);
    }

    /**
     * Removes the equivalent person from the list.
     *
     * @throws PersonNotFoundException if no such person could be found in the list.
     */
    public void remove(Person toRemove) throws PersonNotFoundException {
        final boolean personFoundAndDeleted = internalList.remove(toRemove);
        if (!personFoundAndDeleted) {
            throw new PersonNotFoundException();
        }
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniquePersonList // instanceof handles nulls
                        && this.internalList.equals(((UniquePersonList) other).internalList));
    }

    /**
     * Signals that an operation would have violated the 'no duplicates' property of the list.
     */
    public static class DuplicatePersonException extends DuplicateDataException {
        protected DuplicatePersonException() {
            super("Operation would result in duplicate persons");
        }
    }

    /**
     * Signals that an operation targeting a specified person in the list would fail because
     * there is no such matching person in the list.
     */
    public static class PersonNotFoundException extends Exception {}
}
