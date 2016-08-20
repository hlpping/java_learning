package chap04.factory.abstract03;

public interface Dough {
	public String toString();
}

interface Cheese {
	public String toString();
}

interface Sauce {
	public String toString();
}

interface Veggies {
	public String toString();
}

interface Pepperoni {
	public String toString();
}

interface Clams {
	public String toString();
}

class ThinCrustDough implements Dough {
	public String toString() {
		return "Thin Crust Dough";
	}
}

class ThickCrustDough implements Dough {
	public String toString() {
		return "ThickCrust style extra thick crust dough";
	}
}
class ParmesanCheese implements Cheese {

	public String toString() {
		return "Shredded Parmesan";
	}
}
class MozzarellaCheese implements Cheese {

	public String toString() {
		return "Shredded Mozzarella";
	}
}
class ReggianoCheese implements Cheese {

	public String toString() {
		return "Reggiano Cheese";
	}
}

class SlicedPepperoni implements Pepperoni {

	public String toString() {
		return "Sliced Pepperoni";
	}
}

class PlumTomatoSauce implements Sauce {
	public String toString() {
		return "Tomato sauce with plum tomatoes";
	}
}

class MarinaraSauce implements Sauce {
	public String toString() {
		return "Marinara Sauce";
	}
}

class RedPepper implements Veggies {

	public String toString() {
		return "Red Pepper";
	}
}

class Spinach implements Veggies {

	public String toString() {
		return "Spinach";
	}
}

class Onion implements Veggies {

	public String toString() {
		return "Onion";
	}
}

class Mushroom implements Veggies {

	public String toString() {
		return "Mushrooms";
	}
}

class Garlic implements Veggies {

	public String toString() {
		return "Garlic";
	}
}

class Eggplant implements Veggies {

	public String toString() {
		return "Eggplant";
	}
}

class BlackOlives implements Veggies {

	public String toString() {
		return "Black Olives";
	}
}

class FrozenClams implements Clams {

	public String toString() {
		return "Frozen Clams from Chesapeake Bay";
	}
}
class FreshClams implements Clams {

	public String toString() {
		return "Fresh Clams from Long Island Sound";
	}
}
