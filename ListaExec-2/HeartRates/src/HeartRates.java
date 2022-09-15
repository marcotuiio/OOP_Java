public class HeartRates {
	private String name;
	private String lastName;
	private int dayBirth;
	private int monthBirth;
	private int yearBirth;
	
	public HeartRates(String name, String lastName, int day, int month, int year) {
		this.name = name;
		this.lastName = lastName;
		this.dayBirth = day;
		this.monthBirth = month;
		this.yearBirth = year;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setLastName(String n) {
		this.lastName = n;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setDayBirth(int d) {
		this.dayBirth = d;
	}
	
	public int getDayBirth() {
		return this.dayBirth;
	}
	
	public void setMonthBirth(int m) {
		this.monthBirth = m;
	}
	
	public int getMonthBirth() {
		return this.monthBirth;
	}
	
	public void setYearBirth(int y) {
		this.yearBirth = y;
	}
	
	public int getYearBirth() {
		return this.yearBirth;
	}
	
	public int getAge() {
		return (2022 - this.yearBirth);
	}
	
	public int getMaximumRate() {
		return (220 - this.getAge());
	}
	
	public int[] getRange(int max) {
		int low = 50*max / 100;
		int high = 85*max / 100;
		int[] range = {low, high};
		return range;
	}
}
