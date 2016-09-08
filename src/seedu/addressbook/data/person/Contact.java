package seedu.addressbook.data.person;

public class Contact {
	public String value;
    protected boolean isPrivate;
    
    public Contact() {
        value = "";
    }
    
    public Contact(String value, boolean isPrivate){
        this.value = value;
        this.isPrivate = isPrivate;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
