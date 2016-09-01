 package seedu.addressbook.data.person;
 
 import seedu.addressbook.data.exception.IllegalValueException;
 
 /**
  * Represents a Person's street name in the address book.
  * Guarantees: immutable.
  */
 public class Street {
     public static final String MESSAGE_STREET_CONSTRAINTS = "";
     public static final String STREET_VALIDATION_REGEX = ". ";
     
     public final String value;
     
     /**
      * Validates given street.
      *
      * @throws IllegalValueException if given street string is invalid.
      */
     public Street(String street) throws IllegalValueException {
         if (!isValidStreet(street)) {
             throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
         }
         this.value = street;
     }
     
     /**
      * Returns true if a given string is a valid street name.
      */
     public static boolean isValidStreet(String test) {
         return test.matches(STREET_VALIDATION_REGEX);
     }
 
     @Override
     public String toString() {
         return value;
     }
     
     @Override
     public int hashCode() {
         return value.hashCode();
     }
 }