package seedu.addressbook.data.person;
 
 import seedu.addressbook.data.exception.IllegalValueException;
 
 /**
  * Represents a Person's block number in the address book.
  * Guarantees: immutable.
  */
 public class Block {
     public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block should be either numbers only or numbers with a single alphabet at the back";
     public static final String BLOCK_VALIDATION_REGEX = "^\\d $|^\\d [a-zA-Z]$";
     
     public final String value;
     
     /**
      * Validates given block.
      *
      * @throws IllegalValueException if given block string is invalid.
      */
     public Block(String block) throws IllegalValueException {
         if (!isValidBlock(block)) {
             throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
         }
         this.value = block;
     }
     
     /**
      * Returns true if a given string is a valid block.
      */
     public static boolean isValidBlock(String test) {
         return test.matches(BLOCK_VALIDATION_REGEX);
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