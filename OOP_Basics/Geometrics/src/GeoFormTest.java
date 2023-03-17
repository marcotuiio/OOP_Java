
public class GeoFormTest {

	public static void main(String[] args) {
		GeoFace sf = new SquareFig();
		GeoFace hf = new HexaFig();
		System.out.println("Quadrado N lados: " + sf.obterNumeroLados());
		System.out.println("Hexagono N lados: " + hf.obterNumeroLados());
	}

}
