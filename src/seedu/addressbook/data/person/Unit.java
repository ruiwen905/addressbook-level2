 package seedu.addressbook.data.person;
 
 import seedu.addressbook.data.exception.IllegalValueException;
 
 /**
  * Represents a Person's unit number in the address book.
  * Guarantees: immutable.
  */
 public class Unit {
     public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit number should begin with a hash,"
              + "followed by floor number,"
              + "followed by a hyphen,"
              + "followed by apartment number";
     public static final String UNIT_VALIDATION_REGEX = "^#\\d -\\d $";
     
     public final String value;
 
     /**
      * Validates given unit.
      *
      * @throws IllegalValueException if given unit string is invalid.
      */
     public Unit(String unit) throws IllegalValueException {
         if (!isValidUnit(unit)) {
             throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
         }
         this.value = unit;
     }
     
     /**
      * Returns true if a given string is a valid unit.
      */
     public static boolean isValidUnit(String test) {
         return test.matches(UNIT_VALIDATION_REGEX);
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