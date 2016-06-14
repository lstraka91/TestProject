package register;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
	/** register.Person array. */
	private Person[] persons;

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#setPersons(int, register.Person)
	 */
	@Override
	public void setPersons(int index, Person persons) {
		this.persons[index] = persons;
	}

	/** Number of persons in this register. */
	private int count;

	/**
	 * Constructor creates an empty register with maximum size specified.
	 * 
	 * @param size
	 *            maximum size of the register
	 */
	public ArrayRegister(int size) {
		persons = new Person[size];
		count = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getCount()
	 */
	@Override
	public int getCount() {
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getSize()
	 */
	@Override
	public int getSize() {
		return persons.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getPerson(int)
	 */
	@Override
	public Person getPerson(int index) {
		return persons[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#addPerson(register.Person)
	 */
	@Override
	public void addPerson(Person person) {
		persons[count] = person;
		count++;
	}

	// TODO: Implement the method findPersonByName
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
	@Override
	public Person findPersonByName(String name) {
		Person result = null;
		for (int i = 0; i < persons.length; i++) {
			if (getPerson(i) == null) {
				break;
			}
			if (!(getPerson(i).getName().equalsIgnoreCase(name))) {

				result = new Person(null, null);

			} else {

				return getPerson(i);
			}
		}

		return result;
	}

	// TODO: Implement the method findPersonByPhoneNumber
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
		Person result = null;
		for (int i = 0; i < persons.length; i++) {
			if (getPerson(i) == null) {
				break;
			}
			if (!(getPerson(i).getPhoneNumber().equalsIgnoreCase(phoneNumber))) {

				result = new Person(null, null);

			} else {

				return getPerson(i);
			}
		}
		return result;
	}

	// TODO: Implement the method removePerson
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#removePerson(register.Person)
	 */
	@Override
	public void removePerson(Person person) {
		ArrayRegister register = new ArrayRegister(getSize());
		for (int i = 0; i < getCount(); i++) {
			if (getPerson(i).equals(person)) {

			} else {
				register.addPerson(getPerson(i));
			}
		}
		for (int j = 0; j < register.count; j++) {
			persons[j] = register.getPerson(j);
			if (j == register.count - 1) {
				persons[j + 1] = null;
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#sortArray()
	 */
	@Override
	public void sortArray() {
		for (int i = 0; i < getCount(); i++) {

			for (int j = 0; j < getCount(); j++) {

				if (getPerson(i).getName().compareTo(getPerson(j).getName()) < 0) {

					Person temp = persons[i];
					persons[i] = persons[j];
					persons[j] = temp;

				}

			}

		}
	}

}