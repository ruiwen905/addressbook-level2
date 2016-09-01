 package seedu.addressbook.data.person;
 
 import seedu.addressbook.data.exception.IllegalValueException;
 
 /**
  * Represents a Person's postal code in the address book. Guarantees: immutable.
  */
 public class PostalCode {
     public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Postal code should only contain numbers";
     public static final String POSTAL_CODE_VALIDATION_REGEX = "^\\d $";
     public final String value;
 
     /**
      * Validates given postal code.
      *
      * @throws IllegalValueException if given postal code string is invalid.
      */
     public PostalCode(String postalCode) throws IllegalValueException {
         if (!isValidPostalCode(postalCode)) {
             throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
         }
         this.value = postalCode;
     }
     
     /**
      * Returns true if a given string is a valid postal code.
      */
     public static boolean isValidPostalCode(String test) {
         return test.matches(POSTAL_CODE_VALIDATION_REGEX);
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