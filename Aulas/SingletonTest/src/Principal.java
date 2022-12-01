public class Principal {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++){
			Incremental inc = Incremental.getInstance();
			Incremental inc2 = Incremental.getInstance();
			inc.incrementar();
			inc2.incrementar();
			System.out.println(inc);
		}

	}

}
