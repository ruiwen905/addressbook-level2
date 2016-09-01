package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.util.*;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

	public static final String EXAMPLE = "123, some street, some unit, some postal_code";
	public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format of BLOCK, STREET, UNIT, POSTAL CODE";
	public static final String ADDRESS_VALIDATION_REGEX = ". ";
	private static final int ADDRESS_PARAM_COUNT = 4;

	public final String value;
	private boolean isPrivate;
	private Block block;
	private Street street;
	private Unit unit;
	private PostalCode postalCode;

	/**
	 * Validates given address.
	 *
	 * @throws IllegalValueException if given address string is invalid.
	 */
	public Address(String address, boolean isPrivate) throws IllegalValueException {
		this.isPrivate = isPrivate;
		try {
			partitionAddress(address);
		} 
		catch (IllegalValueException e) {
			throw e;
		}
		this.value = address;
	}

	/**
	 * Returns true if a given string is a valid person email.
	 */
	public static boolean isValidAddress(String address) throws IllegalValueException{
		try {
			HashMap<String, String> addressParams = extractAddressParam(address);
			String block = addressParams.get("block");
			String street = addressParams.get("street");
			String unit = addressParams.get("unit");
			String postalCode = addressParams.get("postalCode");

			if (!Block.isValidBlock(block)) {
				throw new IllegalValueException(Block.MESSAGE_BLOCK_CONSTRAINTS);
			} else if (!Street.isValidStreet(street)) {
				throw new IllegalValueException(Street.MESSAGE_STREET_CONSTRAINTS);
			} else if (!Unit.isValidUnit(unit)) {
				throw new IllegalValueException(Unit.MESSAGE_UNIT_CONSTRAINTS);
			} else if (!PostalCode.isValidPostalCode(postalCode)) {
				throw new IllegalValueException(PostalCode.MESSAGE_POSTAL_CODE_CONSTRAINTS);
			}
		} catch (IllegalValueException e) {
			throw e;
		}
		return true;
	}

	/**
	 * Extract the different parts of the address
	 * 
	 * @return HashMap containing the different parts of the address
	 */
	private static HashMap<String, String> extractAddressParam(String address)throws IllegalValueException {
		StringTokenizer st = new StringTokenizer(address, ",");
		String[] addressParamArr = new String[ADDRESS_PARAM_COUNT];
		int count=0;
		while (st.hasMoreTokens()) {
			addressParamArr[count  ] = st.nextToken().trim();
		}

		if (count == ADDRESS_PARAM_COUNT) {
			HashMap<String, String> addressParamHashMap = new HashMap<String, String>();
			addressParamHashMap.put("block", addressParamArr[0]);
			addressParamHashMap.put("street", addressParamArr[1]);
			addressParamHashMap.put("unit", addressParamArr[2]);
			addressParamHashMap.put("postalCode", addressParamArr[3]);
			return addressParamHashMap;
		}
		else {
			throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
		}
	}

	/**
	 * Update the block, street, unit, postalCode members of Address
	 * @param address
	 * @throws IllegalValueException
	 */
	private void partitionAddress(String address) throws IllegalValueException{
		try { 
			HashMap<String, String> addressParams = extractAddressParam(address);
			block = new Block(addressParams.get("block"));
			street = new Street(addressParams.get("street"));
			unit = new Unit(addressParams.get("unit"));
			postalCode = new PostalCode(addressParams.get("postalCode"));
		} catch (IllegalValueException e) {
			throw e;
		}
	}

	public Block getBlock() {
		return block;
	}

	public Street getStreet() {
		return street;
	}

	public Unit getUnit() {
		return unit;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Address // instanceof handles nulls
						&& this.value.equals(((Address) other).value)); // state check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}