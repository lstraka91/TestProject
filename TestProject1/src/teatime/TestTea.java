package teatime;
public class TestTea {

	public static void main(String[] args) {

		// Tea[] teaArray = { new Tea(), new Tea(Flavours.STRAWBERRY),
		// new Tea(Flavours.LEMON), new Tea(Flavours.MINT) };

		Bevarage[] drinks = { new Tea(), new Tea(Flavours.STRAWBERRY),
				new Tea(Flavours.LEMON), new Tea(Flavours.MINT), new Wine(),
				new Wine(2000, "Pezinok") };
		// TestTea test = new TestTea();
		// test.drinkTea(teaArray);

		for (Bevarage drink : drinks) {
			System.out.println(drink.drink());
		}
	}

	public void drinkTea(Tea[] teaArray) {
		for (int i = 0; i < teaArray.length; i++) {
			teaArray[i].drink();
		}
	}
}
