
public abstract class Pizzaria {
	
	public abstract Pizza createPizza(int sabor);
	
	public Pizza newPizza(int sabor) {
		Pizza p = this.createPizza(sabor);
		return p;
	}
}
