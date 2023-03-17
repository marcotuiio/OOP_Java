
public class SoundEquipment extends Equipment {
	private short volume;
	private boolean stereo;
	
	public SoundEquipment() {
		this.volume = 5;
	}

	public void setVolume(short v) {
		if (v >=0 && v <= 10) {
			this.volume = v;
		}
	}
	
	public short getVolume() {
		return this.volume;
	}
	
	public void setMono() {
		this.stereo = false;
	}
	
	public void setStereo() {
		this.stereo = true;
	}
	
	public boolean getStereo() {
		return this.stereo;
	}
}
