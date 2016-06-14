package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
	/** register.Register of persons. */
	private Register register;

	/**
	 * In JDK 6 use Console class instead.
	 * 
	 * @see readLine()
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * Menu options.
	 */
	private enum Option {
		PRINT, ADD, UPDATE, REMOVE, FIND, SORT, EXIT
	};

	public ConsoleUI(Register register) {
		this.register = register;
	}

	public void run() {
		while (true) {
			switch (showMenu()) {
			case PRINT:
				printRegister();
				break;
			case ADD:
				addToRegister();
				break;
			case UPDATE:
				updateRegister();
				break;
			case REMOVE:
				removeFromRegister();
				break;
			case FIND:
				findInRegister();
				break;
			case SORT:
				sortRegister();
				break;
			case EXIT:
				return;
			}
		}
	}

	private void sortRegister() {
		// printRegister();
		register.sortArray();

	}

	private String readLine() {
		// In JDK 6.0 and above Console class can be used
		// return System.console().readLine();

		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private Option showMenu() {
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	// TODO: Implement the method printRegister
	private void printRegister() {
		for (int i = 0; i < register.getCount(); i++) {
			if (register.getPerson(i) != null) {
				System.out.println((i + 1) + ". "
						+ register.getPerson(i).toString());
			}
		}
	}

	private void addToRegister() {
		System.out.println("Enter Name: ");
		String name = readLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();
 		if (register.findPersonByName(name) == null
				|| register.findPersonByPhoneNumber(phoneNumber) == null) {

			register.addPerson(new Person(name, phoneNumber));
		} else {
			System.out.println("NOTHING ADDED..!!");
			System.out
					.println("person with the same data allready exists try it again");

		}
	}

	// TODO: Implement the method updateRegister
	private void updateRegister() {
		printRegister();
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		register.getPerson(index - 1);
		System.out
				.println("If you don't want to edit name or phone number just leave an empty field");
		System.out.println("Enter Name: ");
		String name = readLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();
		if (!name.equals("")) {
			register.getPerson(index - 1).setName(name);

		}
		if (!phoneNumber.equals("")) {

			register.getPerson(index - 1).setPhoneNumber(phoneNumber);
		}
	}

	// TODO: Implement the method findInRegister
	private void findInRegister() {

		System.out.println("1. Find by name");
		System.out.println("2. Find by phoneNumber");
		System.out.println("Type 1 or 2");
		int number = Integer.parseInt(readLine());
		if (number == 1) {
			System.out.println("Type name by which you want to find:");
			String name = readLine();

			if (register.findPersonByName(name).getName() != null) {

				System.out.println(register.findPersonByName(name).toString());
			} else {
				System.out.println("Sorry nothing matched");
			}

		} else if (number == 2) {
			System.out.println("Type phoneNumber by which you want to find:");
			String phonenumber = readLine();
			if (register.findPersonByPhoneNumber(phonenumber).getPhoneNumber() != null) {
				System.out.println(register
						.findPersonByPhoneNumber(phonenumber).toString());
			} else {
				System.out.println("Sorry nothing matched");
			}

		} else {
			System.out.println("Incorrect chosen number");
			findInRegister();
		}
	}

	private void removeFromRegister() {
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);
		register.removePerson(person);
	}

}
