package teatime;
public class Wine implements Bevarage {

	private int year;
	private String wineYard;

	public Wine(int year, String wineYard) {
		this.wineYard = wineYard;
		setYear(year);
	}

	public Wine() {
		this(2016, "Tokaj");
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year <= 2016 && year >= 1950) {
			this.year = year;
		} else {
			System.out.println("Wine is set to year 2016, because ");
		}
	}

	public String getWineYard() {
		return wineYard;
	}

	public void setWineYard(String wineYard) {
		this.wineYard = wineYard;
	}

	@Override
	public String drink() {
		return "Hmm, this wine is " + getWineYard() + ", and filled in :"
				+ getYear();
	}

}
