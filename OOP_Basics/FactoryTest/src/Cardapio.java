
public class Cardapio extends Pizzaria {

	enum SABORES {
		QUATRO_QUEIJOS,
		CALABRESA,
	}
	
	@Override
	public Pizza createPizza(int sabor) {
		Pizza p = null;
		switch (sabor) {
			case 0:
				p = new Pizza4Queijos();
				break;
			case 1:
				p = new PizzaCalabresa();
				break;
			default:
				System.out.println("Sabor indisponivel");
				break;
		}
		return p;
	}

}
