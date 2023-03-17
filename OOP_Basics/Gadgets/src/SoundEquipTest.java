
public class SoundEquipTest {

	public static void main(String[] args) {
		SoundEquipment jbl = new SoundEquipment();
		
		jbl.turnOn();
		
		System.out.println("\nStatus " + jbl.getStatus() +  " Volume " + jbl.getVolume() + " Stereo " + jbl.getStereo());
		
		jbl.setVolume((short) 9);
		jbl.setStereo();
		System.out.println("\nStatus " + jbl.getStatus() +  " Volume " + jbl.getVolume() + " Stereo " + jbl.getStereo());

	}

}
