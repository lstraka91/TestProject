package teatime;
public class Tea implements Bevarage {

	private Flavours flavour;

	public Tea(Flavours flavour) {
		this.flavour = flavour;
	}

	public Tea() {
		this(Flavours.GREEN);
	}

	private String getFlavourString(Flavours flavour) {
		String flavourString;
		String fresh = "fresh ";
		String tasty = "tasty ";
		String sweet = "sweet ";
		switch (flavour) {
		case MINT:
			flavourString = fresh + flavour.toString().toLowerCase();
			break;
		case GINGER:
			flavourString = tasty + flavour.toString().toLowerCase();
			break;
		case LEMON:
			flavourString = fresh + flavour.toString().toLowerCase();
			break;
		case GREEN:
			flavourString = tasty + flavour.toString().toLowerCase();
			break;
		case STRAWBERRY:
			flavourString = sweet + flavour.toString().toLowerCase();
		default:
			return "unknown flavour of";

		}
		return flavourString;
	}

	public String drink() {
		return ("Mmmm, this " + getFlavourString(flavour) + " tea is delicious");
	}

}
