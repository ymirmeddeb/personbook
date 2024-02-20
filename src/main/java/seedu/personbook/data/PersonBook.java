package seedu.personbook.data;

import seedu.personbook.data.person.Person;
import seedu.personbook.data.person.UniquePersonList;
import seedu.personbook.data.person.UniquePersonList.DuplicatePersonException;
import seedu.personbook.data.person.UniquePersonList.PersonNotFoundException;

import java.util.Collections;
import java.util.List;

/**
 * Represents the entire PersonBook. Contains the data of the PersonBook.
 */
public class PersonBook {

    private final UniquePersonList allPersons;
    
    /** The list of person shown to the user most recently.  */
    private List<Person> lastShownList = Collections.emptyList();

    /**
     * Creates an empty PersonBook.
     */
    public PersonBook() {
        allPersons = new UniquePersonList();
    }


    /**
     * Adds a person to the PersonBook.
     *
     * @throws DuplicatePersonException if an equivalent person already exists.
     */
    public void addPerson(Person toAdd) throws DuplicatePersonException {
        allPersons.add(toAdd);
    }


    /**
     * Removes the equivalent person from the PersonBook.
     *
     * @throws PersonNotFoundException if no such Person could be found.
     */
    public void removePerson(Person toRemove) throws PersonNotFoundException {
        allPersons.remove(toRemove);
    }
    
    
    /**
     * Updates the {@link #lastShownList} if the result contains a list of Persons.
     */
    public void setLastShownList(List<Person> listInResult) {
        if (listInResult != null) {
            lastShownList = listInResult;
        }
    }

    public List<Person> getLastShownList() {
        return lastShownList;
    }

    /**
     * Returns a new UniquePersonList of all persons in the PersonBook at the time of the call.
     */
    public List<Person> getAllPersons() {
        return allPersons.immutableListView();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonBook // instanceof handles nulls
                        && this.allPersons.equals(((PersonBook) other).allPersons));
    }

}
